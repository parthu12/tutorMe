/*
 * Sample seed codes to be used in CS321 at
 * The University of Alabama in Huntsville.
 * These codes may contain errors, poor implementations, or
 * incorrect implementations. The user of these codes should
 * try to correct or improve them. The codes are for instructional
 * purposes. dmr CS 321 Fall 2016
 */
package view.announcement;

/**
 * The concrete version of the <tt>AbstractTableModel</tt> required for the
 * <tt>JTable></tt>
 *
 * @author drochowi for CS 321 Fall 2015, 2016, 2017
 */
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.table.AbstractTableModel;

public class AnnouncementTableModel extends AbstractTableModel {

    // Needs to be fixed. Convert to enum or
    // use strings in case statement. Problem is reliance on ints in interface.
    // TODO Check use of defined constants
    public static final int COURSE = 0;
    public static final int ANNOUNCEMENT = 1;
    public static final int DUEDATE = 2;
    public static final int CONTACTINFO = 3;
    public static final int HIDDEN_INDEX = 4;

    protected String[] columnNames;
    private ArrayList<Announcement> dataArrayList;

    /**
     * Constructor requires an array of column names
     *
     * @param columnNames as an array of <tt>String</tt>
     */
    public AnnouncementTableModel(String[] columnNames) {
        // It would be good to build an alternative constructor that takes
        // both the column names and data values as arguments
        // TODO Build alternative constructor
        this.columnNames = columnNames;
        dataArrayList = new ArrayList<>();
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        //the hidden column cannot be edited
        return (HIDDEN_INDEX == column) ? false : true; // but all other columns can
    }

    @Override
    public Class getColumnClass(int column) {

        switch (column) {
            case COURSE:
            case ANNOUNCEMENT:
            case DUEDATE:
            case CONTACTINFO:
                return String.class;
            default:
                return Object.class;
        }
    }

    @Override
    public Object getValueAt(int row, int column) {
        // Get a DataModelRecord for the specified row of the table model 
        Announcement record = getDataArrayList().get(row);
        // Get the appropriate item from the record or
        // return a new empty object
        switch (column) {
            case COURSE:
                return record.getCourse();
            case ANNOUNCEMENT:
                return record.getAnnouncement();
            case DUEDATE:
                return record.getDueDate();
            case CONTACTINFO:
                return record.getContactInfo();

            default:
                return new Object();
        }
    }

    @Override
    public void setValueAt(Object value, int row, int column) {
        // Get a DataModelRecord for the specified row of the table model
        Announcement record = getDataArrayList().get(row);
        // Set the appropriate field of the record with the
        // new value or print an error message.
        switch (column) {
            case COURSE:
                record.setCourse((String) value);
                break;
            case ANNOUNCEMENT:
                record.setAnnouncement((String) value);
                break;
            case DUEDATE:
                record.setDueDate((String) value);
                break;
            case CONTACTINFO:
                record.setContactInfo((String) value);
                break;
            default:
                // Fix this. Change to a dialog, send to a logger or both
                // TODO Fix error notification in setValueAt
                System.out.println("invalid index");
        }
        // Notify all listeners that the value of the cell has been updated.
        fireTableCellUpdated(row, column);
    }

    @Override
    public int getRowCount() {
        return getDataArrayList().size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    /**
     * Test whether the table has an empty row. If there is an empty row return
     * <tt>true</tt> and false otherwise.
     *
     * @return the <tt>boolean</tt>
     */
    public boolean hasEmptyRow() {
        if (getDataArrayList().isEmpty()) {
            return false;
        }
        Announcement dataRecord = getDataArrayList().get(getDataArrayList().size() - 1);
        return (dataRecord.getCourse().trim().equals("")
                && dataRecord.getAnnouncement().trim().equals("")
                && dataRecord.getDueDate().trim().equals("")
                && dataRecord.getContactInfo().trim().equals(""));
    }

    /**
     * Add an empty row, a <tt>DataModelRecord</tt>, to table model
     */
    public void addEmptyRow() {
        getDataArrayList().add(new Announcement());
        // Notify all listeners that a row has been inserted
        fireTableRowsInserted(getDataArrayList().size() - 1,
                getDataArrayList().size() - 1);
    }

    /**
     * Get an ArrayList of students
     *
     * @return ArrayList of <tt>Student</tt>
     */
    public ArrayList<Announcement> getDataArrayList() {
        // It would be a good idea to make the array of students
        // such that it does not contain a blank record. This would
        // clean up the test when writing an xml file
        // TODO Fix so that blank student is not added
        return dataArrayList;
    }

    /**
     * Set the student list, let listeners know, and add an empty row.
     *
     * @param dataArrayList as an <tt>ArrayList</tt> of <tt>Student</tt>
     */
    public void setDataArrayList(ArrayList<Announcement> dataArrayList) {
        this.dataArrayList = dataArrayList;
        System.out.println("dataArray"+this.dataArrayList);
        fireTableDataChanged();
        addEmptyRow();
    }
}
