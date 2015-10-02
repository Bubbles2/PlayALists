package dcf.matcom.playalists;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

/**
 * Created by dfinlay-air on 26/09/15.
 */
public class RecycAdapter extends RecyclerView.Adapter<RecycAdapter.MyViewHolder> {

    List<String> data= Collections.emptyList();
    private LayoutInflater inflater;
    private Context context;
    public RecycAdapter(Context context, List<String> data){
        this.context=context;
        inflater=LayoutInflater.from(context);
        this.data=data;
    }

    public void delete(int position){
        data.remove(position);
        notifyItemRemoved(position);
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=inflater.inflate(R.layout.recviewrow, parent,false);
        MyViewHolder holder=new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        String  current=data.get(position);
        holder.title.setText(current);
        //holder.icon.setImageResource(current.iconId);
    }
    @Override
    public int getItemCount() {
        return data.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView title;
         public MyViewHolder(View itemView) {
            super(itemView);
            title= (TextView) itemView.findViewById(R.id.txtRecyc1);
           // icon= (ImageView) itemView.findViewById(R.id.listIcon);
        }
    }
}
