package ru.aioki.todo.ui.add

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import ru.aioki.todo.R
import ru.aioki.todo.databinding.FragmentAddBinding

@AndroidEntryPoint
class AddFragment : Fragment() {

    private val viewModel: AddViewModel by viewModels()

    private var mBinding: FragmentAddBinding? = null
    val binding
        get() = mBinding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_add, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnSave.setOnClickListener {
            val title = binding.etTitle.text?.toString()
            val text = binding.etText.text?.toString()
            if (title.isNullOrBlank()) {
                binding.tilTitle.error = "Need title"
                return@setOnClickListener
            }
            if (text.isNullOrBlank()) {
                binding.tilText.error = "Need title"
                return@setOnClickListener
            }
            viewModel.add(
                title = title,
                text = text
            )
            activity?.onBackPressed()
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        mBinding = null
    }

}