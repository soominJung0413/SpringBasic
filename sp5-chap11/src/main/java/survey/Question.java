package survey;

import java.util.Collections;
import java.util.List;

public class Question {
	private String title;
	private List<String> options;

	public Question(String title, List<String> option) {
		this.title = title;
		this.options = option;
	}

	public Question(String title) {
		this(title, Collections.<String>emptyList());
	}

	public List<String> getOptions() {
		return options;
	}

	public String getTitle() {
		return title;
	}

	public boolean isChoice() {
		return options != null && !options.isEmpty();
	}
}
