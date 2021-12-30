package com.hmazud.pdam_kotlin.Model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class MasalahResponse {
    @SerializedName("status")
    @Expose
    var status: String? = null

    @SerializedName("data")
    var masalahDataList: List<MasalahModel?>? = null

    class MasalahModel(
        @field:SerializedName("wilayah") val wilayah: String,
        @field:SerializedName(
            "hari"
        ) val hari: String,
        @field:SerializedName("tanggal") val tanggal: String,
        @field:SerializedName(
            "estimasi"
        ) val estimasi: String,
        @field:SerializedName("est_mulai") val est_mulai: String,
        @field:SerializedName(
            "est_selesai"
        ) val est_selesai: String,
        @field:SerializedName("kerusakan") val kerusakan: String,
        @field:SerializedName(
            "alternatif"
        ) val alternatif: String,
        @field:SerializedName("penanganan") val penanganan: String
    )
}

