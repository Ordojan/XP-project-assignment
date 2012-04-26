package eess



import org.junit.*
import grails.test.mixin.*

@TestFor(SubjectChoiceController)
@Mock(SubjectChoice)
class SubjectChoiceControllerTests {


    def populateValidParams(params) {
      assert params != null
      // TODO: Populate valid properties like...
      //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/subjectChoice/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.subjectChoiceInstanceList.size() == 0
        assert model.subjectChoiceInstanceTotal == 0
    }

    void testCreate() {
       def model = controller.create()

       assert model.subjectChoiceInstance != null
    }

    void testSave() {
        controller.save()

        assert model.subjectChoiceInstance != null
        assert view == '/subjectChoice/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/subjectChoice/show/1'
        assert controller.flash.message != null
        assert SubjectChoice.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/subjectChoice/list'


        populateValidParams(params)
        def subjectChoice = new SubjectChoice(params)

        assert subjectChoice.save() != null

        params.id = subjectChoice.id

        def model = controller.show()

        assert model.subjectChoiceInstance == subjectChoice
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/subjectChoice/list'


        populateValidParams(params)
        def subjectChoice = new SubjectChoice(params)

        assert subjectChoice.save() != null

        params.id = subjectChoice.id

        def model = controller.edit()

        assert model.subjectChoiceInstance == subjectChoice
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/subjectChoice/list'

        response.reset()


        populateValidParams(params)
        def subjectChoice = new SubjectChoice(params)

        assert subjectChoice.save() != null

        // test invalid parameters in update
        params.id = subjectChoice.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/subjectChoice/edit"
        assert model.subjectChoiceInstance != null

        subjectChoice.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/subjectChoice/show/$subjectChoice.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        subjectChoice.clearErrors()

        populateValidParams(params)
        params.id = subjectChoice.id
        params.version = -1
        controller.update()

        assert view == "/subjectChoice/edit"
        assert model.subjectChoiceInstance != null
        assert model.subjectChoiceInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/subjectChoice/list'

        response.reset()

        populateValidParams(params)
        def subjectChoice = new SubjectChoice(params)

        assert subjectChoice.save() != null
        assert SubjectChoice.count() == 1

        params.id = subjectChoice.id

        controller.delete()

        assert SubjectChoice.count() == 0
        assert SubjectChoice.get(subjectChoice.id) == null
        assert response.redirectedUrl == '/subjectChoice/list'
    }
}
