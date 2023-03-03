package ru.aioki.todo.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingComponent
import androidx.recyclerview.widget.RecyclerView
import ru.aioki.todo.data.domain.TodoDomain
import ru.aioki.todo.databinding.ItemTodoBinding

class TodoAdapter : RecyclerView.Adapter<TodoAdapter.ViewHolder>() {

    private val list: MutableList<TodoDomain> = mutableListOf()

    fun add(list: List<TodoDomain>) {
        this.list.clear()
        this.list.addAll(list)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemTodoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    private var onFinishCallback: ((TodoDomain) -> Unit)? = null

    fun setOnFinishListener(block: (TodoDomain) -> Unit) {
        onFinishCallback = block
    }

    inner class ViewHolder(private val binding: ItemTodoBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: TodoDomain) {
            binding.cbFinish.isChecked = item.isFinished
            binding.tvTitle.text = item.title
            binding.tvText.text = item.text

            binding.cbFinish.setOnClickListener {
                item.isFinished = !item.isFinished
                onFinishCallback?.invoke(item)
            }
        }
    }
}
