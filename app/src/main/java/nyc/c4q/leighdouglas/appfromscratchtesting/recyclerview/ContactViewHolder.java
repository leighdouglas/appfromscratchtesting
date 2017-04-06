package nyc.c4q.leighdouglas.appfromscratchtesting.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import nyc.c4q.leighdouglas.appfromscratchtesting.R;
import nyc.c4q.leighdouglas.appfromscratchtesting.backend.ContactInfo;

/**
 * Created by leighdouglas on 4/5/17.
 */

public class ContactViewHolder extends RecyclerView.ViewHolder {
    private TextView id;
    private TextView name;
    private TextView mobile;

    public ContactViewHolder(View itemView) {
        super(itemView);
        initViews();
    }

    public void bind(ContactInfo ci){
        name.setText(ci.getName());
        id.setText(ci.getId());
        mobile.setText(ci.getPhone().getMobile());
    }

    private void initViews(){
        id = (TextView) itemView.findViewById(R.id.id);
        name = (TextView) itemView.findViewById(R.id.name);
        mobile = (TextView) itemView.findViewById(R.id.mobile);

    }
}
