import java.util.*;

/**
 * Test the program independent from regular program sequence
 */
public class TestMain {
    //region Constants
    //endregion

    //region Attributes
    //endregion

    //region Constructor
    private TestMain() {}
    //endregion

    //region Methods
    public static void main(String[] args) {
        System.out.println("TestMain:\n");

        List<Note> notes = TestData.getTestNotes();
        FileHandler.getInstance().saveNotesToCsvFile(notes);
    }
    
    public static void sortByImportanceAndTitle(List<Note> list) {

        list.sort((firstNote, secondNote) -> {
            // Sort Notes based on importance
            Boolean firstNoteImportant = firstNote.isImportant();
            Boolean secondNoteImportant = secondNote.isImportant();

            int boolCompare = firstNoteImportant.compareTo(secondNoteImportant);

            if (boolCompare != 0) {
                return -boolCompare;

            } else  {
                String firstNoteTitle = firstNote.getTitle();
                String secondNoteTitle = secondNote.getTitle();

                int stringCompare = firstNoteTitle.compareTo(secondNoteTitle);
                return -stringCompare;
            }
        });
    }
    //endregion
}
