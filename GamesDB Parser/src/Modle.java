import com.datastax.driver.core.BoundStatement;
import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.PreparedStatement;
import com.datastax.driver.core.Session;


public class Modle {
	
	Cluster cluster;
	CassandraHosts cass =  new CassandraHosts();
	
	public void setCluster(Cluster cluster) {
		this.cluster = CassandraHosts.getCluster();
	}
	
	public void AddToDb(int Id, String GameName) {
		Session session = cluster.connect("igdatabase");
		PreparedStatement statement = session
				.prepare("Insert into gameinfotable (gameid  , gameName ) values ( ? , ?);");
		BoundStatement boundStatement = new BoundStatement(statement);

		boundStatement.bind(Id, GameName);

		session.execute(boundStatement);
		session.close();
	}

}
