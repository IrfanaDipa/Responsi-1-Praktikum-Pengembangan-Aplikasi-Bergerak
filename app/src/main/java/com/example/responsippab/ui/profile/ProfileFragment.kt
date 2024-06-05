package com.example.responsippab.ui.profile

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.responsippab.R
import com.example.responsippab.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {
    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.share).setOnClickListener { shareProfileInformation() }
    }

    private fun shareProfileInformation() {
        val information = "Nama        | Irfan Adi Prasetya\n" +
                "NIM         | L0122079\n" +
                "Prodi       | Informatika\n" +
                "Fakultas    | FATISDA\n" +
                "Universitas | UNS\n"
        val subject = "Praktikum PAB - Responsi"
        val intent = Intent(Intent.ACTION_SEND)

        intent.type = "text/plain"
        intent.putExtra(Intent.EXTRA_SUBJECT, subject)
        intent.putExtra(Intent.EXTRA_TEXT, information)
        startActivity(Intent.createChooser(intent, "SHARE PROFILE VIA"))
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}