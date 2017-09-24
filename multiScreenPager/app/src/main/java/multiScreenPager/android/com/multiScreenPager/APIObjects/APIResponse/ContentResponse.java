package multiScreenPager.android.com.multiScreenPager.APIObjects.APIResponse;

import java.io.Serializable;

import multiScreenPager.android.com.multiScreenPager.APIObjects.Objects.Content;

public class ContentResponse extends ApiResponse implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Content result;

	public Content getResult() {
		return result;
	}

	public void setResult(Content result) {
		this.result = result;
	}
}
