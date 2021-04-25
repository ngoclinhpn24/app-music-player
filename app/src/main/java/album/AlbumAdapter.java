package album;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mainscreen2.R;

import java.util.List;

public class AlbumAdapter extends RecyclerView.Adapter<AlbumAdapter.AlbumViewHolder>{

    private List<Album> mAlbums;

    public void setData(List<Album> list){
        this.mAlbums = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public AlbumViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_home, parent, false);
        return new AlbumViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AlbumViewHolder holder, int position) {
        Album album = mAlbums.get(position);
        if(album == null){
            return;
        }

        holder.imgAlbum.setImageResource(album.getResourceId());
        holder.tvTitle.setText(album.getTitle());
    }

    @Override
    public int getItemCount() {
        if (mAlbums != null){
            return mAlbums.size();
        }
        return 0;
    }

    public class AlbumViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgAlbum;
        private TextView tvTitle;

        public AlbumViewHolder(@NonNull View itemView) {
            super(itemView);

            imgAlbum = itemView.findViewById(R.id.img_album);
            tvTitle = itemView.findViewById(R.id.tv_title);
        }
    }
}
