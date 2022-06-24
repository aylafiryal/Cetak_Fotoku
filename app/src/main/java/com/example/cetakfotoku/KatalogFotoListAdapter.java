package com.example.cetakfotoku;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class KatalogFotoListAdapter extends RecyclerView.Adapter<KatalogFotoListAdapter.KatalogFotoViewHolder> {

    private LayoutInflater mInfLater;

    public KatalogFotoListAdapter(Context context){
        mInfLater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public KatalogFotoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = mInfLater.inflate(R.layout.katalog_foto_item,parent, false);
        return new KatalogFotoViewHolder(itemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull KatalogFotoViewHolder holder, int position) {
        KatalogFoto katalogFoto = KatalogFotoUtil.getKatalogFotoAt(position);
        holder.ivKatalogFoto.setImageResource(katalogFoto.getResId());
        holder.tvFilenameKatalogFoto.setText(katalogFoto.getFileName());
    }

    @Override
    public int getItemCount() {
        return KatalogFotoUtil.getKatalogFotoList().size();
    }

    public static class KatalogFotoViewHolder extends RecyclerView.ViewHolder{

        final Button btnCetak;
        final Button[] btnUkuranArray;
        final ImageView ivKatalogFoto;
        final TextView tvFilenameKatalogFoto;
        private KatalogFotoListAdapter mAdapter;

        private int[] resBtnUkuranArray = {
                R.id.btn_3r,
                R.id.btn_4r,
                R.id.btn_8r,
                R.id.btn_10r
        };


        public KatalogFotoViewHolder(@NonNull View itemview, KatalogFotoListAdapter _mAdapter){
            super(itemview);
            mAdapter = _mAdapter;

            btnCetak = itemview.findViewById(R.id.btn_cetak);

            ivKatalogFoto = itemview.findViewById(R.id.iv_katalog_foto);
            tvFilenameKatalogFoto = itemview.findViewById(R.id.tv_katalog_filename);

            btnUkuranArray = new Button[resBtnUkuranArray.length];

            for(int i = 0; i < resBtnUkuranArray.length; i++){
                btnUkuranArray[i] = itemview.findViewById(resBtnUkuranArray[i]);

                btnUkuranArray[i].setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Button btn = (Button) view;
                        int itemPos = getLayoutPosition();
                        OrderFotoUtil.addOrder(KatalogFotoUtil.getKatalogFotoAt(itemPos), btn.getText().toString());
                    }
                });
            }

        }
    }
}
