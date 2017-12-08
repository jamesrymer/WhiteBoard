import javax.swing.table.AbstractTableModel;

public class TableModel extends AbstractTableModel implements ModelListener {

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		//this.
		return null;
	}

	@Override
	public void ModelChanged(DShapeModel model) {
		//fireTableRowsUpdated(rowNum,rowNum)
		
	}

}
