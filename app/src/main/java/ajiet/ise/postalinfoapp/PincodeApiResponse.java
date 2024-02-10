package ajiet.ise.postalinfoapp;

public class PincodeApiResponse {
    private String Status;
    private PostOffice[] PostOffice;

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public PostOffice[] getPostOffice() {
        return PostOffice;
    }

    public void setPostOffice(PostOffice[] postOffice) {
        PostOffice = postOffice;
    }

}

