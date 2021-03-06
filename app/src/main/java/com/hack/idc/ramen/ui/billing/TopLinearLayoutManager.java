package com.hack.idc.ramen.ui.billing;

import android.content.Context;

import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
public class TopLinearLayoutManager extends LinearLayoutManager
{
    public TopLinearLayoutManager(Context context, int orientation)
    {
        super(context, orientation, false);
    }

    @Override
    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int position)
    {
        RecyclerView.SmoothScroller smoothScroller = new CenterSmoothScroller(recyclerView.getContext());
        smoothScroller.setTargetPosition(position);
        startSmoothScroll(smoothScroller);
    }

    private static class CenterSmoothScroller extends LinearSmoothScroller
    {
        CenterSmoothScroller(Context context)
        {
            super(context);
        }

        @Override
        public int calculateDtToFit(int viewStart, int viewEnd, int boxStart, int boxEnd, int snapPreference)
        {
            return (boxStart + (boxEnd - boxStart) / 10) - (viewStart + (viewEnd - viewStart) / 10);
        }
    }
}