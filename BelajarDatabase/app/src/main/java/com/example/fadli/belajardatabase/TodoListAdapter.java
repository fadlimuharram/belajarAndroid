package com.example.fadli.belajardatabase;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by fadli on 3/9/18.
 */

public class TodoListAdapter extends RecyclerView.Adapter<TodoListAdapter.TodoViewHolder> {

    static String EDITITEMNAME = "EDITITEM_NAME";
    static String EDITITEMPRIORITY = "EDITITEM_PRIORITY";
    static String EDITITEMID = "EDITITEM_ID";
    private ArrayList<Item> itemArrayList;
    private Context context;

    public TodoListAdapter(ArrayList<Item> itemArrayList, Context context) {
        this.itemArrayList = itemArrayList;
        this.context = context;
    }

    @Override
    public TodoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item,parent,false);

        return new TodoViewHolder(v);
    }

    @Override
    public void onBindViewHolder(TodoViewHolder holder, int position) {
        final Item item = itemArrayList.get(position);
        holder.todoText.setText(item.getName());

        holder.editImageView.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,AddEditActivity.class);
                intent.putExtra(EDITITEMNAME,item.getName());
                intent.putExtra(EDITITEMPRIORITY,item.getPriority());
                intent.putExtra(EDITITEMID,item.getId());
                context.startActivity(intent);
            }
        });

        holder.doneImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyDatabase db = new MyDatabase(context);
                db.deleteItem(item.getId());

                itemArrayList.clear();
                itemArrayList.addAll(db.getAll());
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return itemArrayList.size();
    }


    public class TodoViewHolder extends RecyclerView.ViewHolder {
        TextView todoText;
        ImageView editImageView;
        ImageView doneImageView;

        public TodoViewHolder(View itemView) {
            super(itemView);
            todoText = itemView.findViewById(R.id.todo_name);
            editImageView = itemView.findViewById(R.id.edit_todo);
            doneImageView = itemView.findViewById(R.id.done_todo);
        }
    }
}
