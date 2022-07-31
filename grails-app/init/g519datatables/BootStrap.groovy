package g519datatables

import grails.gorm.transactions.Transactional
import wood.mike.Cyclist

import java.time.LocalDate

class BootStrap {

    def init = { servletContext ->
        createCyclists()
    }

    @Transactional
    def createCyclists() {
        new Cyclist(forename: 'Sep', surname: 'Vanmarcke', dateOfBirth: LocalDate.parse('1988-07-28' ), nationality: 'Beglium').save()
        new Cyclist(forename: 'Alejandro', surname: 'Valverde', dateOfBirth: LocalDate.parse('1980-04-25' ), nationality: 'Spain').save()
        new Cyclist(forename: 'Chris', surname: 'Froome', dateOfBirth: LocalDate.parse('1985-05-20' ), nationality: 'Great Britain').save()
        new Cyclist(forename: 'Peter', surname: 'Sagan', dateOfBirth: LocalDate.parse('1990-01-26' ), nationality: 'Slovakia').save()
        new Cyclist(forename: 'Jakob', surname: 'Fuglsang', dateOfBirth: LocalDate.parse('1985-03-22' ), nationality: 'Denmark').save()
        new Cyclist(forename: 'Bauke', surname: 'Mollema', dateOfBirth: LocalDate.parse('1986-11-26' ), nationality: 'Netherlands').save()
        new Cyclist(forename: 'Mathieu', surname: 'van der Poel', dateOfBirth: LocalDate.parse('1995-01-19' ), nationality: 'Netherlands').save()
        new Cyclist(forename: 'Mark', surname: 'Cavendish', dateOfBirth: LocalDate.parse('1985-05-21' ), nationality: 'Great Britain').save()
        new Cyclist(forename: 'Rigoberto', surname: 'Uran', dateOfBirth: LocalDate.parse('1987-01-26' ), nationality: 'Colombia').save()
        new Cyclist(forename: 'Michał', surname: 'Kwiatkowski', dateOfBirth: LocalDate.parse('1990-02-06'), nationality: 'Poland').save()
        new Cyclist(forename: 'Luis León', surname: 'Sánchez', dateOfBirth: LocalDate.parse('1983-11-24'), nationality: 'Spain').save()
        new Cyclist(forename: 'Daryl', surname: 'Impey', dateOfBirth: LocalDate.parse('1984-12-06'), nationality: 'South Africa').save()
        new Cyclist(forename: 'Wout', surname: 'van Aert', dateOfBirth: LocalDate.parse('1994-09-15'), nationality: 'Belgium').save()
        new Cyclist(forename: 'Julian', surname: 'Alaphilippe', dateOfBirth: LocalDate.parse('1992-06-11'), nationality: 'France').save()
        new Cyclist(forename: 'Mads', surname: 'Pedersen', dateOfBirth: LocalDate.parse('1995-12-18'), nationality: 'Denmark').save()
        new Cyclist(forename: 'Søren', surname: 'Kragh Andersen', dateOfBirth: LocalDate.parse('1994-08-10'), nationality: 'Denmark').save()
        new Cyclist(forename: 'Nils', surname: 'Politt', dateOfBirth: LocalDate.parse('1994-03-06'), nationality: 'Germany').save()
        new Cyclist(forename: 'Jan', surname: 'Tratnik', dateOfBirth: LocalDate.parse('1990-02-23'), nationality: 'Slovenia').save()
        new Cyclist(forename: 'Dylan', surname: 'Teuns', dateOfBirth: LocalDate.parse('1992-03-01'), nationality: 'Belgium').save()
        new Cyclist(forename: 'Edvald', surname: 'Boasson Hagen', dateOfBirth: LocalDate.parse('1987-05-17'), nationality: 'Normay').save()
    }

    def destroy = {
    }
}
