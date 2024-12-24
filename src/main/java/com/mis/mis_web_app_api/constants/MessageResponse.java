package com.mis.mis_web_app_api.constants;

import lombok.*;
import org.springframework.context.annotation.Bean;

/**
 * Represents a standard message response
 */

@Data
public class MessageResponse {

    private String status;
    private String message;
    private String messageKh;
    private Object data;

    public MessageResponse(){}
    public MessageResponse(String status, String message, String messageKh, Object data) {
        this.status = status;
        this.message = message;
        this.messageKh = messageKh;
        this.data = data;
    }

    @Override
    public String toString() {
        return "MessageResponse{" +
                "status='" + status + '\'' +
                ", message='" + message + '\'' +
                ", messageKh='" + messageKh + '\'' +
                ", data=" + data +
                '}';
    }


    /**
     * Sets the response data with a success message and code.
     *
     * @param data The data to be included in the response.
     */

    public void setGetDataSuccess(Object data) {
        this.status = "ជោគជ័យ";
        this.message = "Retrieve data successfully!";
        this.messageKh = "ទាញយកទិន្នន័យដោយជោគជ័យ!";
        this.data = data;
    }

    public void setCreateDataSuccess(Object data) {
        this.status = "ជោគជ័យ";
        this.message = "Create data successfully!";
        this.messageKh = "បង្កើតទិន្នន័យដោយជោគជ័យ!";
        this.data = data;
    }

    public void setUpdateDataSuccess(Object data) {
        this.status = "ជោគជ័យ";
        this.message = "Update data successfully!";
        this.messageKh = "កែប្រែទិន្នន័យដោយជោគជ័យ!";
        this.data = data;
    }

    public void setDeleteDataSuccess(Object data) {
        this.status = "ជោគជ័យ";
        this.message = "Delete data successfully";
        this.messageKh = "លុបទិន្នន័យដោយជោគជ័យ!";
        this.data = data;
    }

    public void setErrorMessage(String message){
        this.status = "Error";
        this.message = message;
    }
}
