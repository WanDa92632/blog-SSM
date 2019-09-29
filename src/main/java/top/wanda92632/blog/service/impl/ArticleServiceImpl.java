package top.wanda92632.blog.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.wanda92632.blog.dao.ArticleCategoryDao;
import top.wanda92632.blog.dao.CommentDao;
import top.wanda92632.blog.dao.UserDao;
import top.wanda92632.blog.entity.Article;
import top.wanda92632.blog.dao.ArticleDao;
import top.wanda92632.blog.entity.ArticleCategory;
import top.wanda92632.blog.service.ArticleService;

import java.util.List;

/**
 * @author ZhiFei
 */
@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    ArticleDao articleDao;
    @Autowired
    UserDao userDao;
    @Autowired
    CommentDao commentDao;
    @Autowired
    ArticleCategoryDao articleCategoryDao;

    /**
     * 获取文章
     * @param articleId
     * @return
     */
    @Override
    public Article getArticle(int articleId) {
        Article article = articleDao.getArticle(articleId);
        return article;
    }

    /**
     * 提交文章
     * @param article
     */
    @Override
    public void setArticle(Article article) {
        articleDao.setArticle(article);
        ArticleCategory articleCategory=new ArticleCategory();
        articleCategory.setArticleId(article.getArticleId());
        articleCategory.setCategoryId(article.getCategory().getCategoryId());
        articleCategoryDao.setArticleCategory(articleCategory);
    }

    /**
     * 获取主页文章
     * @param begin
     * @return
     */
    @Override
    public  List<Article> getHomeArticle(int begin) {
        return articleDao.getHomeArticle(begin);
    }

    /**
     * 删除文章
     * @param articleId
     */
    @Override
    public void deleteArticle(Integer articleId)
    {
        articleDao.deleteArticle(articleId);
    }

    /**
     * 获取用户的所有文章
     * @param userId
     * @return
     */
    @Override
    public List<Article> getAllArticleByUserID(Integer userId){
        List<Article> articleList = articleDao.getAllArticleByUserID(userId);
        return articleList;
    }

    /**
     * 增加以已阅读数
     * @param articleId
     */
    @Override
    public void addArticleViewed(Integer articleId) {
        articleDao.addArticleViewed(articleId);
    }

    /**
     * 查询文章-标题
     * @param title
     * @param begin
     * @return
     */
    @Override
    public List<Article> queryArticleByTitle(String title,int begin){
        return articleDao.queryArticleByTitle(title,begin);
    }

    /**
     * 查询文章-标题数量
     *
     * @param title
     * @return
     */
    @Override
    public int queryArticleByTitleCount(String title) {
        return articleDao.queryArticleByTitleCount(title);
    }

    /**
     * 查询文章-类别
     * @param categoryName
     * @param begin
     * @return
     */
    @Override
    public List<Article> queryArticleByCategory(String categoryName,int begin){
        return articleDao.queryArticleByCategory(categoryName,begin);
    }

    /**
     * 查询文章-类别数量
     *
     * @param categoryName
     * @return
     */
    @Override
    public int getArticleByTitleCount(String categoryName) {
        return articleDao.queryArticleByCategoryCount(categoryName);
    }

    /**
     * 查询文章总数
     * @return
     */
    @Override
    public int queryArticleSum() {
        return articleDao.queryArticleSum();
    }

    /**
     * 获取最新文章
     *
     * @return
     */
    @Override
    public List<Article> queryLatestArticle() {
        return articleDao.queryLatestArticle();
    }

    /**
     * 获取热门文章
     *
     * @return
     */
    @Override
    public List<Article> queryPopularArticle() {
        return articleDao.queryPopularArticle();
    }

    /**
     * 查询用户发表文章数
     *
     * @param userId
     * @return
     */
    @Override
    public Integer queryArticleSumByUserId(Integer userId) {
        return articleDao.queryArticleSumByUserId(userId);
    }


}
