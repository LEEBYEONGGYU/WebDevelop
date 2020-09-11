package yju.wdb.domain;

import java.util.List;

public class SampleDTOList {

	private List<sampleDTO> list;

	public List<sampleDTO> getList() {
		return list;
	}

	public void setList(List<sampleDTO> list) {
		this.list = list;
	}
	
	public String toString() {
		if (list == null) return "Empty";
		StringBuffer sbuf = new StringBuffer();
		for (int i=0; i<list.size(); i++) {
			sbuf.append(list.get(i)).append("\n");
		}
		return sbuf.toString();
	}
	// Test URL : http://localhost:8000/sample/objList?list%5B0%5D.name=aaa&list%5B0%5D.age=20&list%5B1%5D.name=bbb&list%5B2%5D.name=ccc
}
