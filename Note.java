/**
 * Note class is the Model class which has a titel, content and a flag,
 * which shows whether the note is important.
 * TODO 1: Create and implement Model class
 */
public class Note {
    //region Constants
    private static final String DEF_STR_VAL = ">noData<";
    private static final boolean DEF_BOOL_VAL = false;
    //endregion

    //region Attributes
    private String title;
    private String content;
    private boolean isImportant;
    //endregion

    //region Constructor
    /**
     * Standard Constructor with defined initial values
     */
    public Note() {
        title = DEF_STR_VAL;
        content = DEF_STR_VAL;
        isImportant = DEF_BOOL_VAL;
    }

    public Note(String title, String content) {
        this();
        this.title = title;
        this.content = content;
    }

    public Note(String title, String content, boolean isImportant) {
        this.title = title;
        this.content = content;
        this.isImportant = isImportant;
    }
    //endregion

    //region Methods

    public String getTitle() {return title;}

    public void setTitle(String title) {this.title = title;}

    public String getContent() {return content;}

    public void setContent(String content) {this.content = content;}

    public boolean isImportant() {return isImportant;}

    public void setImportant(boolean important) {isImportant = important;}

    @Override
    public String toString() {
        return "Note{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", isImportant=" + isImportant +
                '}';
    }
//endregion
}
