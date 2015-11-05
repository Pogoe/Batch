package exporter;

import batch.BatchServerImplService;
import batch.IBatchServer;
import batch.Meassure;

public class BatchClient
{
    private BatchServerImplService service;
    private IBatchServer server;
    
    public BatchClient()
    {
        service = new BatchServerImplService();
        server = service.getBatchServerImplPort();
    }
    
    public void acceptData(Meassure m)
    {
        server.acceptData(m);
    }
}
