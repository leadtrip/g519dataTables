import grails.converters.JSON
import wood.mike.Cyclist

import java.text.SimpleDateFormat
import java.time.format.DateTimeFormatter
import java.time.format.FormatStyle

// Place your Spring DSL code here
beans = {

    JSON.registerObjectMarshaller( Cyclist ) {
        def output = [:]

        output['forename'] = it.forename
        output['surname'] = it.surname
        output['nationality'] = it.nationality
        output['dateOfBirth'] = it.dateOfBirth.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM))

        output
    }
}
