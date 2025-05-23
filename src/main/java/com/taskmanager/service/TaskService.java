package com.taskmanager.service;

import com.taskmanager.model.Task;
import com.taskmanager.model.TaskStatus;
import com.taskmanager.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService {
    private final TaskRepository taskRepository;

    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @Scheduled(fixedRate = 21600000) // 6 hours in milliseconds
    @Transactional
    public void updateTaskStatuses() {
        List<Task> tasks = taskRepository.findAll();
        
        for (Task task : tasks) {
            TaskStatus currentStatus = task.getStatus();
            TaskStatus newStatus = getNextStatus(currentStatus);
            
            if (newStatus != currentStatus) {
                task.setStatus(newStatus);
                taskRepository.save(task);
            }
        }
    }

    private TaskStatus getNextStatus(TaskStatus currentStatus) {
        return switch (currentStatus) {
            case PENDING -> TaskStatus.IN_PROGRESS;
            case IN_PROGRESS -> TaskStatus.REVIEW;
            case REVIEW -> TaskStatus.COMPLETED;
            case COMPLETED -> TaskStatus.COMPLETED;
        };
    }
} 