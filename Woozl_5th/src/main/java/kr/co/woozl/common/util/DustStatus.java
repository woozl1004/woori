package kr.co.woozl.common.util;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import kr.co.woozl.base.to.DustStatusTO;

public class DustStatus {

	public static List<DustStatusTO> sendDustStatus() throws Exception {

		new ArrayList<>();
		
		StringBuilder urlBuilder = new StringBuilder(
		"http://openapi.airkorea.or.kr/openapi/services/rest/ArpltnInforInqireSvc/getCtprvnRltmMesureDnsty?"
	    +"ServiceKey=yjpAk8CuwUcr58Avi3hU%2Fe5twtAWMwhruLW48I%2B%2BKzmwiM%2BpN%2BJSWDfEbGDBvB0mhu38HhvWCFlbnDoiJSHgwQ%3D%3D&"
		+"numOfRows=10&pageNo=1&sidoName=%EA%B2%BD%EB%82%A8&dat&dataTerm=DAILY&ver=1.3"); // URL

		URL url = new URL(urlBuilder.toString());

		HttpURLConnection conn = (HttpURLConnection) url.openConnection();

		conn.setRequestMethod("GET");
		System.out.println("Response code: " + conn.getResponseCode());
		System.out.println("getResponseMessage: " + conn.getResponseMessage());
		Document doc = null;
		List<DustStatusTO> dustStatusList = new ArrayList<>();
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			doc = builder.parse(conn.getInputStream());
			NodeList descNodes = doc.getElementsByTagName("item");
			System.out.println(descNodes.getLength());
			for (int i = 0; i < descNodes.getLength(); i++) {
				DustStatusTO dustTO = new DustStatusTO();
				
				for (Node node = descNodes.item(i).getFirstChild(); node != null; node = node.getNextSibling()) { // 첫번째 자식을 시작으로
																												  // 마지막까지  다음 형제를 실행
					if (node.getNodeName().equals("stationName")) {

						System.out.println(node.getTextContent());
						dustTO.setStationName(node.getTextContent());
					}
					if (node.getNodeName().equals("dataTime")) {

						System.out.println(node.getTextContent());
						dustTO.setDataTime(node.getTextContent());

					}
					if (node.getNodeName().equals("pm10Value")) {

						System.out.println(node.getTextContent());
						dustTO.setPm10Value(node.getTextContent());

					}
					if (node.getNodeName().equals("pm25Value")) {

						System.out.println(node.getTextContent());
						dustTO.setPm25Value(node.getTextContent());
					}
					if (node.getNodeName().equals("o3Value")) {

						System.out.println(node.getTextContent());
						dustTO.setO3Value(node.getTextContent());
					}

				}
				dustStatusList.add(dustTO);
			}
		} catch (Exception ex) {
			throw ex;
		}

		conn.disconnect();

		return dustStatusList;
	}

}
