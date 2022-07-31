package wood.mike

import grails.converters.JSON

class CyclistController {

    def cyclistService

    def index() {}

    def find() {
        render cyclistService.find( params ) as JSON
    }
}
