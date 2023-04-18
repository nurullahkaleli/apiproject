package pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DummyResponsePojo {

    private String status;
    private DummyRestApiPojo data;

    public DummyResponsePojo() {
    }

    public DummyResponsePojo(String status, DummyRestApiPojo data) {
        this.status = status;
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public DummyRestApiPojo getData() {
        return data;
    }

    public void setData(DummyRestApiPojo data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "DummyResponsePojo{" +
                "status='" + status + '\'' +
                ", data=" + data +
                '}';
    }
}
