package by.bsu.slabko.vladislav.slabkovmtask.recycleSwipe;

import android.graphics.Canvas;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import by.bsu.slabko.vladislav.slabkovmtask.App;
import by.bsu.slabko.vladislav.slabkovmtask.MVP.MainContract;
import by.bsu.slabko.vladislav.slabkovmtask.MVP.Views.adapters.ListAdapter;

public class SwipeToDeleteCallback extends ItemTouchHelper.SimpleCallback {
    private ListAdapter mListadapter;
    private MainContract.View view;

    public SwipeToDeleteCallback(ListAdapter listAdapter, MainContract.View view) {
        super(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT);
        mListadapter = listAdapter;
        this.view = view;
    }

    @Override
    public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder viewHolder1) {
        System.out.println();
        return false;
    }

    @Override
    public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        mListadapter.deleteItem(viewHolder.getAdapterPosition());
        view.updateScreenList("updateList");
    }

    @Override
    public void onChildDraw(@NonNull Canvas c, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {
        super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
    }
}
