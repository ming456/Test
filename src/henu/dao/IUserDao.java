package henu.dao;

import henu.bean.User;

import java.util.List;

public interface IUserDao {
	/**
	 * �û���¼
	 * 
	 * @param username
	 *            �û���
	 * @param password
	 *            ����
	 * @return ����¼�ɹ�����true������false
	 */
	public boolean login(String username, String password);

	/**
	 * �����û�
	 * 
	 * @param user
	 *            �û���
	 * @return ��Ӱ��ļ�¼����
	 */
	public int save(User user);

	/**
	 * �����û���ɾ��
	 * 
	 * @param username
	 *            �û���
	 * @return ��Ӱ��ļ�¼����
	 */
	public int delete(String username);

	/**
	 * �����û����޸��û���Ϣ
	 * 
	 * @param username
	 *            �û���
	 * @param user
	 *            �µ��û���Ϣ
	 * @return ��Ӱ��ļ�¼����
	 */
	public int update(String username, User user);

	/**
	 * ���������û���Ϣ
	 * 
	 * @return List���͵��û���Ϣ
	 */
	public List<User> findAll();

	/**
	 * �����û������ҵ����û�
	 * 
	 * @param username
	 *            �û���
	 * @return User ����
	 */
	public User findByUsername(String name);
}
