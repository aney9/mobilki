package com.example.pract16;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private Context context;
    private ArrayList<book> bookList;

    public RecyclerViewAdapter(Context context, ArrayList<book> bookArrayList) {
        this.context = context;
        this.bookList = bookArrayList;
    }

    @NonNull
    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_card, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.ViewHolder holder, int position) {
        book Book = bookList.get(position);
        holder.bookName.setText(Book.getBook_Name());
        holder.bookAuthor.setText(Book.getBook_Author());

        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, AddBookActivity.class);
            intent.putExtra("BOOK_ID", book.getID_Book());
            intent.putExtra("BOOK_NAME", book.getBook_Name());
            intent.putExtra("BOOK_AUTHOR", book.getBook_Author());
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return bookList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView bookName;
        TextView bookAuthor;
        public ViewHolder(@NonNull View itemView){
            super(itemView);
            bookName = itemView.findViewById(R.id.b_name);
            bookAuthor = itemView.findViewById(R.id.b_author);
        }
    }
}
