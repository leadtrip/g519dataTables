package wood.mike

import grails.gorm.transactions.Transactional

import java.time.LocalDate
import java.time.Month

@Transactional
class CyclistService {

    /**
     * This is fine for a tiny example like this but wouldn't scale well.
     * Multiple mid string wildcard searches would kill a large, busy database
     */
    def find( params ) {
        def c = Cyclist.createCriteria()
        def cyclists = c.list( max: params.length, offset: params.start ) {
            def searched = searched(params)
            if ( searched ) {
                if(searched[0])
                    ilike("forename", "%${searched[0]}%")
                if(searched[1])
                    ilike("surname", "%${searched[1]}%")
                if(searched[2])
                    ilike("nationality", "%${searched[2]}%")
                if(searched[3] && searched[3].length() == 4)
                    between("dateOfBirth",
                            LocalDate.of(searched[3] as int, Month.JANUARY, 1),
                            LocalDate.of(searched[3] as int, Month.DECEMBER, 31 ))
            }
        }
        def recordsTotal = Cyclist.count
        [data: cyclists, recordsTotal: recordsTotal, recordsFiltered: cyclists.totalCount]
    }

    def searched(params) {
        [params.'columns[0][search][value]',
         params.'columns[1][search][value]',
         params.'columns[2][search][value]',
         params.'columns[3][search][value]']
    }
}
