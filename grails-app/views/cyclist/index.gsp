<%@ page import="java.time.Year" contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Cyclists</title>

    <script type="text/javascript">
        $(document).ready(function(){

            $('.textFilter').each(function () {
                var title = $(this).text();
                $(this).html('<input type="text" placeholder="Search ' + title + '" />');
            });

            $('.yearFilter').each(function () {
                var title = $(this).text();
                $(this).html('<input type="number" min="1980" max="${Year.now().value - 15}" placeholder="Search ' + title + '" />');
            });

            var table = $( '#cyclistTable' ).DataTable({
                "processing": true,
                "serverSide": true,
                "ajax": {
                    "url": "${g.createLink( controller: 'cyclist', action: 'find')}"
                },
                dom: '<"top"r>lBrtip',
                "columns": [
                    {"data": "forename"},
                    {"data": "surname"},
                    {"data": "nationality"},
                    {"data": "dateOfBirth"}
                ],
                "pageLength": 10,
                "language": {
                    "emptyTable": "No cyclists",
                    "processing": '<g:img file="spinner.gif" />'
                },
                "buttons": [ 'copy', 'csv', 'excel', 'pdf', 'print' ],
                "initComplete": function () {

                    // Free text search on forename, surname and nationality
                    this.api().columns([0,1,2]).every(function () {
                        var that = this;

                        $('input', this.footer()).on('keyup change clear', function () {
                            if (that.search() !== this.value) {
                                that.search(this.value).draw();
                            }
                        });
                    });

                    // search by year
                    this.api().columns(3).every( function () {
                        var that = this;

                        $('input', this.footer()).on('keyup change clear', function () {
                            if (that.search() !== this.value && (this.value.length === 0 || this.value.length === 4)) {
                                that.search(this.value).draw();
                            }
                        });
                    });
        /*
            The following works but searching by a single date isn't useful hence why I'm using the year based filter above
        */
/*                    this.api().columns(3).every( function () {
                        var column = this;

                        // Turn off autocomplete
                        var fromDate = $(' <input id="dateOfBirth" autocomplete="off" type="text" class="form-control" data-plugin="datepicker" placeholder="Filter by date of birth"></input> ')
                            .appendTo( $(column.footer()).empty() )
                            .on( 'keyup change clear', function () {
                                if ( column.search() !== this.value ) {
                                    column
                                        .search( this.value )
                                        .draw();
                                }
                            });
                        // Init datapicker with format matching the column data
                        $('#dateOfBirth').datepicker({
                            format: 'yyyy-mm-dd',
                        });
                    } );*/
                }
            });
        });
    </script>
</head>

<body>
<table class="table table-striped table-bordered table-condensed" id="cyclistTable">
    <thead>
    <tr>
        <td>Forename</td>
        <td>Surname</td>
        <td>Nationality</td>
        <td>DOB</td>
    </tr>
    </thead>
    <tfoot>
    <tr>
        <th class="textFilter">Forename</th>
        <th class="textFilter">Surname</th>
        <th class="textFilter">Nationality</th>
        <th class="yearFilter">DOB</th>
    </tr>
    </tfoot>
</table>
</body>
</html>