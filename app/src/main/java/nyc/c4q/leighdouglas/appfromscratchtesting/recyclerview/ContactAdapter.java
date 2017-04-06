package nyc.c4q.leighdouglas.appfromscratchtesting.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import nyc.c4q.leighdouglas.appfromscratchtesting.R;
import nyc.c4q.leighdouglas.appfromscratchtesting.backend.ContactInfo;

/**
 * Created by leighdouglas on 4/5/17.
 */

public class ContactAdapter extends RecyclerView.Adapter<ContactViewHolder> {
    List<ContactInfo> list = new ArrayList<>();
    @Override
    public ContactViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.contact_viewholder, parent, false);
        return new ContactViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ContactViewHolder holder, int position) {
        ContactInfo ci = list.get(position);
        holder.bind(ci);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setList(ArrayList<ContactInfo> list){
        this.list = list;
        notifyDataSetChanged();
    }
}
