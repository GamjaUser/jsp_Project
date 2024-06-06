package DTO;

public class MemberDTO {
    @Override
	public String toString() {
		return "MemberDTO [id=" + id + ", password=" + password + ", gender=" + gender + ", age=" + age + ", goals="
				+ goals + ", exerciseEXP=" + exerciseEXP + ", level=" + level + "]";
	}

	private String id;
    private String password;
    private String gender;
    private int age;
    private int goals;
    private int exerciseEXP;
    private int level;

    // Getter와 Setter
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getGoals() {
        return goals;
    }

    public void setGoals(int goals) {
        this.goals = goals;
    }

    public int getExerciseEXP() {
        return exerciseEXP;
    }

    public void setExerciseEXP(int exerciseEXP) {
        this.exerciseEXP = exerciseEXP;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
