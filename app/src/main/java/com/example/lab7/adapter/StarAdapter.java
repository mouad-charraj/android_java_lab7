package com.example.lab7.adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.lab7.R;
import com.example.lab7.beans.Star;
import com.example.lab7.service.StarService;

import java.util.ArrayList;
import java.util.List;

/**
 * Adaptateur pour afficher les personnages Hero 108 - Personnalisé par Mouad
 */
public class StarAdapter extends RecyclerView.Adapter<StarAdapter.StarViewHolder> implements Filterable {

    private List<Star> stars_mouad;
    private List<Star> stars_filter_mouad;
    private Context context_mouad;
    private MouadFilter filter_mouad;

    public StarAdapter(Context context_mouad, List<Star> stars_mouad) {
        this.context_mouad = context_mouad;
        this.stars_mouad = stars_mouad;
        this.stars_filter_mouad = new ArrayList<>(stars_mouad);
        this.filter_mouad = new MouadFilter(this);
    }

    @NonNull
    @Override
    public StarViewHolder onCreateViewHolder(@NonNull ViewGroup group_mouad, int type_mouad) {
        View view_mouad = LayoutInflater.from(this.context_mouad).inflate(R.layout.star_item, group_mouad, false);
        final StarViewHolder holder_mouad = new StarViewHolder(view_mouad);
        
        holder_mouad.itemView.setOnClickListener(v_mouad -> {
            int position_mouad = holder_mouad.getAdapterPosition();
            if (position_mouad == RecyclerView.NO_POSITION) return;

            Star clicked_star_mouad = stars_filter_mouad.get(position_mouad);

            View popup_mouad = LayoutInflater.from(context_mouad).inflate(R.layout.star_edit_item, null, false);
            ImageView img_mouad = popup_mouad.findViewById(R.id.img);
            RatingBar bar_mouad = popup_mouad.findViewById(R.id.ratingBar);
            TextView id_text_mouad = popup_mouad.findViewById(R.id.idss);

            Glide.with(context_mouad)
                    .load(clicked_star_mouad.getImg())
                    .apply(new RequestOptions().placeholder(R.mipmap.ic_launcher))
                    .into(img_mouad);

            bar_mouad.setRating(clicked_star_mouad.getRating());
            id_text_mouad.setText(String.valueOf(clicked_star_mouad.getId()));

            new AlertDialog.Builder(context_mouad)
                    .setTitle("Notez le héros (Par Mouad) :")
                    .setView(popup_mouad)
                    .setPositiveButton("Valider", (dialog_mouad, which_mouad) -> {
                        float note_mouad = bar_mouad.getRating();
                        int id_mouad = Integer.parseInt(id_text_mouad.getText().toString());
                        Star star_mouad = StarService.getInstance().findById(id_mouad);
                        if (star_mouad != null) {
                            star_mouad.setRating(note_mouad);
                            StarService.getInstance().update(star_mouad);
                            notifyItemChanged(holder_mouad.getAdapterPosition());
                        }
                    })
                    .setNegativeButton("Annuler", null)
                    .show();
        });
        return holder_mouad;
    }

    @Override
    public void onBindViewHolder(@NonNull StarViewHolder holder_mouad, int position_mouad) {
        Star current_star_mouad = stars_filter_mouad.get(position_mouad);
        
        Glide.with(context_mouad)
                .load(current_star_mouad.getImg())
                .apply(new RequestOptions().placeholder(R.mipmap.ic_launcher))
                .into(holder_mouad.img_mouad);

        holder_mouad.name_mouad.setText(current_star_mouad.getName());
        holder_mouad.stars_mouad.setRating(current_star_mouad.getRating());
        holder_mouad.id_mouad.setText(String.valueOf(current_star_mouad.getId()));
    }

    @Override
    public int getItemCount() {
        return stars_filter_mouad.size();
    }

    @Override
    public Filter getFilter() {
        return filter_mouad;
    }

    public static class StarViewHolder extends RecyclerView.ViewHolder {
        TextView id_mouad, name_mouad;
        ImageView img_mouad;
        RatingBar stars_mouad;

        public StarViewHolder(@NonNull View item_mouad) {
            super(item_mouad);
            id_mouad = item_mouad.findViewById(R.id.ids);
            img_mouad = item_mouad.findViewById(R.id.img);
            name_mouad = item_mouad.findViewById(R.id.name);
            stars_mouad = item_mouad.findViewById(R.id.stars);
        }
    }

    public class MouadFilter extends Filter {
        private final RecyclerView.Adapter<?> adapter_mouad;

        public MouadFilter(RecyclerView.Adapter<?> adapter_mouad) {
            this.adapter_mouad = adapter_mouad;
        }

        @Override
        protected FilterResults performFiltering(CharSequence pattern_mouad) {
            List<Star> results_list_mouad = new ArrayList<>();
            if (pattern_mouad == null || pattern_mouad.length() == 0) {
                results_list_mouad.addAll(stars_mouad);
            } else {
                String clean_pattern_mouad = pattern_mouad.toString().toLowerCase().trim();
                for (Star s_mouad : stars_mouad) {
                    if (s_mouad.getName().toLowerCase().contains(clean_pattern_mouad)) {
                        results_list_mouad.add(s_mouad);
                    }
                }
            }
            FilterResults final_results_mouad = new FilterResults();
            final_results_mouad.values = results_list_mouad;
            final_results_mouad.count = results_list_mouad.size();
            return final_results_mouad;
        }

        @Override
        protected void publishResults(CharSequence pattern_mouad, FilterResults results_mouad) {
            stars_filter_mouad = (List<Star>) results_mouad.values;
            adapter_mouad.notifyDataSetChanged();
        }
    }
}
