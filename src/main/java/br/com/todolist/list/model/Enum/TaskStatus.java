package br.com.todolist.list.model.Enum;


import lombok.*;


@NoArgsConstructor
@Getter
public enum TaskStatus {
    DONE("DONE"),
    PENDING("PENDING");

    private String status;
    TaskStatus(String status){
        this.status = status;
    }

    public String getStatus(){
        return status;
    }
}
