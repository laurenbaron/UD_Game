package cisc181.lab_4;

/**
 * Swetha Sankar & Lauren Baron
 * CISC 181-080
 * Final Project
 * 5/18/20
 * Recruiter Interface
 */
public interface Recruiter {
    /**
     * when a piece recruits another piece for their team
     * @param rowRecruiter -- the row index of the piece that is recruiting
     * @param colRecruiter -- the column index of the piece that is recruiting
     * @param rowRecruitee -- the row index of the piece the recruiter is recruiting
     * @param colRecruitee -- the column index of the piece the recruiter is recruiting
     */
    public abstract void recruit(int rowRecruiter, int colRecruiter, int rowRecruitee, int colRecruitee);
}
