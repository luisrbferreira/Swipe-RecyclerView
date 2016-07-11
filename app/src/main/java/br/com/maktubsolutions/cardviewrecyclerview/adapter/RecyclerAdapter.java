package br.com.maktubsolutions.cardviewrecyclerview.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import br.com.maktubsolutions.cardviewrecyclerview.R;

/**
 * Created by luis.ferreira on 07/07/2016.
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    private List<String> items;

    public RecyclerAdapter(List<String> listas) {
        this.items = listas;
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cardview_layout, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerAdapter.ViewHolder viewHolder, int i) {

        viewHolder.name.setText(items.get(i));
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView name;

        public ViewHolder(View view) {
            super(view);

            name = (TextView) view.findViewById(R.id.textViewName);
        }
    }

    public void addItem(String item) {
        items.add(item);
        notifyItemInserted(items.size());
    }

    public void removeItem(int position) {
        items.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, items.size());
    }
}