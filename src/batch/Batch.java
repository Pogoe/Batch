package batch;

public class Batch
{
    private BatchServerImplService service;
    private IBatchServer server;
    
    public void connect()
    {
        service = new BatchServerImplService();
        server = service.getBatchServerImplPort();
    }
}
