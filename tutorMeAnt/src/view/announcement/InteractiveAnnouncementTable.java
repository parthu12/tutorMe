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
 * Builds a <tt>JPanel</tt> for an interactive form that will allow editing of
 * an empty
 * <tt>JTable</tt> that can extend the number of rows for editing.
 *
 * @author drochowi for CS 321 Fall 2015, 2016, 2017
 */
import java.awt.BorderLayout;
import java.awt.Component;
import java.util.ArrayList;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 * The <tt>InteractiveStudentTable</tt> extends <tt>JPanel</tt> and contains the
 * elements need to have a functioning <tt>JTable</tt>. The idea is that from
 * the point of view of constructing the user interface, this subclass of
 * <tt>JTable</tt> can be dropped into the design where the functionality of an
 * interactive student table is needed. At this point the approach is a bit
 * rough. We will need to think about how it can be improved.
 *
 * @author drochowi for CS 321 Fall 2015, 2016
 */
public class InteractiveAnnouncementTable extends JPanel {
// TODO Should be generalized so that data is passed in without hard coding

    protected static final String[] columnNames = {
        "Course", "Announcement", "Due Date", "Contact Info", ""};

    protected JTable table;
    protected JScrollPane scroller;
    private AnnouncementTableModel tableModel;

    /**
     * Constructor that returns a panel with an interactive student table in it
     * Should consider separating the table and component
     */
    // TODO Separate table and panel
    public InteractiveAnnouncementTable() {
        initComponent();
    }

    private void initComponent() {
        // Make the table model using the column names
        tableModel = new AnnouncementTableModel(columnNames);
        // Add a custom table model listener to the table.
        getTableModel().addTableModelListener(new InteractiveTableModelListener());
        // Create the JTable and add the table model
        table = new JTable();
        table.setModel(getTableModel());

        // The editor should get the focus when keystrokes cause the editor to be activated
        table.setSurrendersFocusOnKeystroke(true);
        // if the table does not have an empty row, add one
        if (!tableModel.hasEmptyRow()) {
            getTableModel().addEmptyRow();
        }

        // Place the table in a scroll pane and set preferred size
        scroller = new JScrollPane(table);
        // Set a preferred visible size for the scrollable table
        table.setPreferredScrollableViewportSize(new java.awt.Dimension(500, 100));
        // Make a small (visible size) hidden column,
        // although there is no current use for this it can be handy if it
        //is needed
        TableColumn hidden = table.getColumnModel().getColumn(AnnouncementTableModel.HIDDEN_INDEX);
        hidden.setMinWidth(2);
        hidden.setPreferredWidth(2);
        hidden.setMaxWidth(2);
        hidden.setCellRenderer(new InteractiveRenderer(AnnouncementTableModel.HIDDEN_INDEX));

        // Set the layout for the panel and put the scrolling table in the center
        setLayout(new BorderLayout());
        add(scroller, BorderLayout.CENTER);
    }

    /**
     * Visually highlight the last row
     *
     * @param row as an <tt>int</tt> to be highlighted
     */
    public void highlightLastRow(int row) {
        //Identify the last row
        int lastrow = getTableModel().getRowCount();
        // If the row is right before the last row,
        if (row == lastrow - 1) {
            //then select this row,
            table.setRowSelectionInterval(lastrow - 1, lastrow - 1);
        } else {
            // otherwise select the row after this row
            table.setRowSelectionInterval(row + 1, row + 1);
        }
        // By default select the first row
        table.setColumnSelectionInterval(0, 0);
    }

    /**
     * Get the table model
     *
     * @return the <tt>tableModel</tt> as a <tt>StudentTableModel</tt>
     */
    public AnnouncementTableModel getTableModel() {
        return tableModel;
    }

    /**
     * Get the table model data
     *
     * @return students as an <tt>ArrayList</tt> of <tt>Student</tt>
     */
    public ArrayList<Announcement> getTableModelData() {
        // This seems to be a hack. Attempt to fix it.
        // TODO Might be a hack
        System.out.println(tableModel.getDataArrayList());
        return tableModel.getDataArrayList();
    }

    /**
     * Set the data of the table model
     *
     * @param students as an <tt>ArrayList</tt> of <tt>Student</tt>
     */
    public void setTableModelData(ArrayList<Announcement> announcement) {
        // This seems to be a hack that complements the getTableModelData hack.
        // attempt to fix this.
        // TODO Might be a hack
        System.out.println("a"+announcement);
        tableModel.setDataArrayList(announcement);

    }

    /**
     * Private inner class for rendering cells This might well be moved. This
     * would especially be the case if the cell renderer became either more
     * complex or needed by other code constructs.
     */
    private class InteractiveRenderer extends DefaultTableCellRenderer {

        protected int interactiveColumn;

        /**
         * Create a renderer for a column
         *
         * @param interactiveColumn as <tt>int</tt> that indicates the column
         * for rendering
         */
        public InteractiveRenderer(int interactiveColumn) {
            this.interactiveColumn = interactiveColumn;
        }

        @Override
        public Component getTableCellRendererComponent(JTable table,
                Object value, boolean isSelected, boolean hasFocus, int row,
                int column) {
            // Get the appropriate component
            Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            // If the requested column has focus,
            if (column == interactiveColumn && hasFocus) {
                // and if this is the last row, and there is no empty row,
                if ((InteractiveAnnouncementTable.this.getTableModel().getRowCount() - 1) == row
                        && !InteractiveAnnouncementTable.this.tableModel.hasEmptyRow()) {
                    // add an empty row
                    InteractiveAnnouncementTable.this.getTableModel().addEmptyRow();
                }
                // Highlight the row
                highlightLastRow(row);
            }
            // Return the component
            return c;
        }
    }

    /**
     * Private inner class to provide custom behavior for the table model
     * listener. This might be refactored to provide additional functionality
     * and usability.
     */
    private class InteractiveTableModelListener implements TableModelListener {

        @Override
        public void tableChanged(TableModelEvent evt) {
            // If this is an update event,
            if (evt.getType() == TableModelEvent.UPDATE) {
                // get the column and row from the TableModelEvent
                int column = evt.getColumn();
                int row = evt.getFirstRow();
                //Set the column and row selection intervals for the table
                table.setColumnSelectionInterval(column + 1, column + 1);
                table.setRowSelectionInterval(row, row);
            }
        }
    }

}
