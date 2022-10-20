/**
 * Create a static Method to generate data
 * TODO 6 Create TestData class
 */
public class TestData {
    //region Constants
    private static final int TEST_NOTE_AMOUNT = 10;
    //endregion

    //region Attributes
    //endregion

    //region Constructor
    private TestData() {}
    //endregion

    //region Methods

    /**
     * Generate test-notes and print them back
     * @return {@Link Note} : testNote array
     * TODO 7: Implement a testNotes method
     */
    public static Note[] getTestNotes() {
        Note[] testNotes = new Note[TEST_NOTE_AMOUNT];

        for (int i = 0; i < TEST_NOTE_AMOUNT; i++) {
            testNotes[i] = new Note("Note Titel " + i, "Note Content " + i);
            if (i % 3 == 0) testNotes[i].setImportant(true);
        }

        return testNotes;
    }
    //endregion
}
