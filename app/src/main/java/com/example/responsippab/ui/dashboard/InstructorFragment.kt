package com.example.responsippab.ui.dashboard

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.responsippab.R
import com.example.responsippab.adapter.InstructorAdapter
import com.example.responsippab.databinding.FragmentInstructorBinding
import com.example.responsippab.dataclass.InstructorProfile

class InstructorFragment : Fragment() {
    private var _binding: FragmentInstructorBinding? = null
    private val binding get() = _binding!!

    private lateinit var recyclerView: RecyclerView
    private val listInstructor = ArrayList<InstructorProfile>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentInstructorBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.rv_instructor_card)
        recyclerView.setHasFixedSize(true)

//        Function onOptionsItemSelected is deprecated for fragment
//        This is the alternative
        (requireActivity() as MenuHost).addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.option_menu, menu)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                when (menuItem.itemId) {
                    R.id.action_list -> {
                        recyclerView.layoutManager = LinearLayoutManager(context)
                        return true
                    }
                    R.id.action_grid -> {
                        recyclerView.layoutManager = GridLayoutManager(context, 2)
                        return true
                    }
                }
                return false
            }
        }, viewLifecycleOwner)

        listInstructor.addAll(getListInstructor())
        recyclerView.layoutManager = LinearLayoutManager(context)
        val instructorAdapter = InstructorAdapter(listInstructor)
        recyclerView.adapter = instructorAdapter

        instructorAdapter.onItemClicked = { data ->
            val intent = Intent(context, DetailInstructorActivity::class.java).apply {
                putExtra("image", data.instructorPhoto)
                putExtra("name", data.instructorName)
                putExtra("detail", data.instructorDetail)
            }
            startActivity(intent)
        }
    }

    private fun getListInstructor(): ArrayList<InstructorProfile> {
        val dataPhoto = resources.obtainTypedArray(R.array.instructor_photo)
        val dataName = resources.getStringArray(R.array.instructor_name)
        val dataDetail = resources.getStringArray(R.array.instructor_detail)

        val listInstructor = ArrayList<InstructorProfile>()
        for (i in dataName.indices) {
            val instructor = InstructorProfile(
                dataPhoto.getResourceId(i, -1), dataName[i], dataDetail[i]
            )
            listInstructor.add(instructor)
        }
        dataPhoto.recycle()
        return listInstructor
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}