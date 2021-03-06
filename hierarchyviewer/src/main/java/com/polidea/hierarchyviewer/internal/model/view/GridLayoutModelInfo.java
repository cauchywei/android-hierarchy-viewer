package com.polidea.hierarchyviewer.internal.model.view;

import android.view.View;
import android.widget.GridLayout;
import com.google.gson.annotations.SerializedName;
import com.polidea.hierarchyviewer.internal.logic.ConvertersContainer;

public class GridLayoutModelInfo extends ViewGroupModelInfo {

    interface Metadata {
        String COLUMN_COUNT = "column_count";
        String ROW_COUNT = "row_count";
        String IS_COLUMN_ORDER_PRESERVED = "is_column_order_preserved";
        String IS_ROW_ORDER_RESERVED = "is_row_order_preserved";
        String ALIGNMENT_MODE = "alignment_mode";
    }

    @SerializedName(Metadata.COLUMN_COUNT)
    int columnCount;

    @SerializedName(Metadata.ROW_COUNT)
    int rowCount;

    @SerializedName(Metadata.IS_COLUMN_ORDER_PRESERVED)
    boolean isColumnOrderPreserved;

    @SerializedName(Metadata.IS_ROW_ORDER_RESERVED)
    boolean isRowOrderPreserved;

    @SerializedName(Metadata.ALIGNMENT_MODE)
    AlignmentMode alignmentMode;

    @Override
    public void setDataFromView(View view, ConvertersContainer convertersContainer) {
        super.setDataFromView(view, convertersContainer);
        GridLayout gridLayout = (GridLayout) view;
        columnCount = gridLayout.getColumnCount();
        rowCount = gridLayout.getRowCount();
        isColumnOrderPreserved = gridLayout.isColumnOrderPreserved();
        isRowOrderPreserved = gridLayout.isRowOrderPreserved();
        alignmentMode = AlignmentMode.getAlignmentMode(gridLayout.getAlignmentMode());
    }
}
