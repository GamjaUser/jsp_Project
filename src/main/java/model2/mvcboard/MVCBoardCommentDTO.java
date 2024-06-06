package model2.mvcboard;

import java.util.Date;

public class MVCBoardCommentDTO {
    @Override
	public String toString() {
		return "MVCBoardCommentDTO [idx=" + idx + ", boardIdx=" + boardIdx + ", name=" + name + ", content=" + content
				+ ", postdate=" + postdate + "]";
	}

	private int idx;	// comment_idx
    private int boardIdx;	// board_idx
    private String name;	// id2
    private String content;
    private Date postdate;	// reg_date

    // getters and setters
    public int getIdx() {
        return idx;
    }

    public void setIdx(int idx) {
        this.idx = idx;
    }

    public int getBoardIdx() {
        return boardIdx;
    }

    public void setBoardIdx(int boardIdx) {
        this.boardIdx = boardIdx;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getPostdate() {
        return postdate;
    }

    public void setPostdate(Date postdate) {
        this.postdate = postdate;
    }
}
