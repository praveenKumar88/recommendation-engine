package org.grails.recommendation

class FunctionalTestsController {
//    static responseFormats = ['json']
//
//    FunctionalTestsController() {
//        super(Book)
//    }
//
//    @Override
//    def save() {
//        def jsonParams = request.JSON
//        render new Book(title: jsonParams.title).save() as JSON
//    }
//
//    def calculateSum(int a) {
//        render (view:'result', model:[answer:a])
//    }
//
//    def calculateDiff(int b) {
//        render (view:'result', model:[answer:b])
//    }

        def displayForm() {
        }
        def index(int a, int b) {
            render "Hello World"
        }
        def calculateDiff(int a, int b) {
            render (view:'result', model:[answer:a-b])
        }
        def calculateProduct(int a, int b) {
            render (view:'result', model:[answer:a*b])
        }
        def calculateQuotient(int a, int b) {
            render (view:'result', model:[answer:a/b])
        }


}
