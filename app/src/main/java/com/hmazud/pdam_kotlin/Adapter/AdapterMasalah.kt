package com.hmazud.pdam_kotlin.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.hmazud.pdam_kotlin.Model.MasalahResponse
import com.hmazud.pdam_kotlin.R

class MasalahAdapter(masalahDataList: List<MasalahResponse.MasalahModel?>?) :
    RecyclerView.Adapter<MasalahAdapter.ViewHolder>() {
    val masalahDataList: List<MasalahResponse.MasalahModel> = masalahDataList as List<MasalahResponse.MasalahModel>
    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val view: View =
            LayoutInflater.from(viewGroup.context).inflate(R.layout.masalah_list, viewGroup, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        viewHolder.mTxtWilayah.text = masalahDataList[i].wilayah
        viewHolder.mTxtHari.text = masalahDataList[i].hari
        viewHolder.mTxtTanggal.text = masalahDataList[i].tanggal
        viewHolder.mTxtEstimasi.text = masalahDataList[i].estimasi
        viewHolder.mTxtEstMulai.text = masalahDataList[i].est_mulai
        viewHolder.mTxtEstSelesai.text = masalahDataList[i].est_selesai
        viewHolder.mTxtKerusakan.text = masalahDataList[i].kerusakan
        viewHolder.mTxtAlternatif.text = masalahDataList[i].alternatif
        viewHolder.mTxtPenanganan.text = masalahDataList[i].penanganan
    }

    override fun getItemCount(): Int {
        return masalahDataList.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var mTxtWilayah: TextView = itemView.findViewById(R.id.txtNama)
        var mTxtHari: TextView = itemView.findViewById(R.id.txtAlamat)
        var mTxtTanggal: TextView = itemView.findViewById(R.id.txtNoHp)
        var mTxtEstimasi: TextView = itemView.findViewById(R.id.txtEstimasi)
        var mTxtEstMulai: TextView = itemView.findViewById(R.id.txtEstMulai)
        var mTxtEstSelesai: TextView = itemView.findViewById(R.id.txtEstSelesai)
        var mTxtKerusakan: TextView = itemView.findViewById(R.id.txtKerusakan)
        var mTxtAlternatif: TextView = itemView.findViewById(R.id.txtAlternatif)
        var mTxtPenanganan: TextView = itemView.findViewById(R.id.txtPenanganan)

    }

}