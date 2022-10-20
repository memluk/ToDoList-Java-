/**
 * Test the program independent from regular program sequence
 * TODO 5 Create a TestMain and Test Model class
 * TODO 8 Test the method getTestNotes() from TestData class
 */
public class TestMain {
    //region Constants
    //endregion

    //region Attributes
    //endregion

    //region Constructor
    //endregion

    //region Methods
    public static void main(String[] args) {
        System.out.println("TestMain:\n");

        //Test getTestNotes method from TestData-Class
        Note[] notes = TestData.getTestNotes();

        for (Note note: notes) {
            System.out.println(note);
        }
    }
    //endregion
}
