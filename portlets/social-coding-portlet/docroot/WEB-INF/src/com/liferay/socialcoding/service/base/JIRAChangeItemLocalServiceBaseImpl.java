/**
 * Copyright (c) 2000-2010 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.socialcoding.service.base;

import com.liferay.counter.service.CounterLocalService;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.service.ResourceLocalService;
import com.liferay.portal.service.ResourceService;
import com.liferay.portal.service.UserLocalService;
import com.liferay.portal.service.UserService;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;

import com.liferay.socialcoding.model.JIRAChangeItem;
import com.liferay.socialcoding.service.JIRAActionLocalService;
import com.liferay.socialcoding.service.JIRAChangeGroupLocalService;
import com.liferay.socialcoding.service.JIRAChangeItemLocalService;
import com.liferay.socialcoding.service.JIRAIssueLocalService;
import com.liferay.socialcoding.service.SVNRepositoryLocalService;
import com.liferay.socialcoding.service.SVNRevisionLocalService;
import com.liferay.socialcoding.service.persistence.JIRAActionFinder;
import com.liferay.socialcoding.service.persistence.JIRAActionPersistence;
import com.liferay.socialcoding.service.persistence.JIRAChangeGroupFinder;
import com.liferay.socialcoding.service.persistence.JIRAChangeGroupPersistence;
import com.liferay.socialcoding.service.persistence.JIRAChangeItemPersistence;
import com.liferay.socialcoding.service.persistence.JIRAIssueFinder;
import com.liferay.socialcoding.service.persistence.JIRAIssuePersistence;
import com.liferay.socialcoding.service.persistence.SVNRepositoryPersistence;
import com.liferay.socialcoding.service.persistence.SVNRevisionPersistence;

import java.util.List;

import javax.sql.DataSource;

/**
 * The base implementation of the j i r a change item local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.liferay.socialcoding.service.impl.JIRAChangeItemLocalServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.socialcoding.service.impl.JIRAChangeItemLocalServiceImpl
 * @see com.liferay.socialcoding.service.JIRAChangeItemLocalServiceUtil
 * @generated
 */
public abstract class JIRAChangeItemLocalServiceBaseImpl
	implements JIRAChangeItemLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.liferay.socialcoding.service.JIRAChangeItemLocalServiceUtil} to access the j i r a change item local service.
	 */

	/**
	 * Adds the j i r a change item to the database. Also notifies the appropriate model listeners.
	 *
	 * @param jiraChangeItem the j i r a change item to add
	 * @return the j i r a change item that was added
	 * @throws SystemException if a system exception occurred
	 */
	public JIRAChangeItem addJIRAChangeItem(JIRAChangeItem jiraChangeItem)
		throws SystemException {
		jiraChangeItem.setNew(true);

		return jiraChangeItemPersistence.update(jiraChangeItem, false);
	}

	/**
	 * Creates a new j i r a change item with the primary key. Does not add the j i r a change item to the database.
	 *
	 * @param jiraChangeItemId the primary key for the new j i r a change item
	 * @return the new j i r a change item
	 */
	public JIRAChangeItem createJIRAChangeItem(long jiraChangeItemId) {
		return jiraChangeItemPersistence.create(jiraChangeItemId);
	}

	/**
	 * Deletes the j i r a change item with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param jiraChangeItemId the primary key of the j i r a change item to delete
	 * @throws PortalException if a j i r a change item with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public void deleteJIRAChangeItem(long jiraChangeItemId)
		throws PortalException, SystemException {
		jiraChangeItemPersistence.remove(jiraChangeItemId);
	}

	/**
	 * Deletes the j i r a change item from the database. Also notifies the appropriate model listeners.
	 *
	 * @param jiraChangeItem the j i r a change item to delete
	 * @throws SystemException if a system exception occurred
	 */
	public void deleteJIRAChangeItem(JIRAChangeItem jiraChangeItem)
		throws SystemException {
		jiraChangeItemPersistence.remove(jiraChangeItem);
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query to search with
	 * @return the matching rows
	 * @throws SystemException if a system exception occurred
	 */
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return jiraChangeItemPersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query to search with
	 * @param start the lower bound of the range of model instances to return
	 * @param end the upper bound of the range of model instances to return (not inclusive)
	 * @return the range of matching rows
	 * @throws SystemException if a system exception occurred
	 */
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return jiraChangeItemPersistence.findWithDynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query to search with
	 * @param start the lower bound of the range of model instances to return
	 * @param end the upper bound of the range of model instances to return (not inclusive)
	 * @param orderByComparator the comparator to order the results by
	 * @return the ordered range of matching rows
	 * @throws SystemException if a system exception occurred
	 */
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return jiraChangeItemPersistence.findWithDynamicQuery(dynamicQuery,
			start, end, orderByComparator);
	}

	/**
	 * Counts the number of rows that match the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query to search with
	 * @return the number of rows that match the dynamic query
	 * @throws SystemException if a system exception occurred
	 */
	public long dynamicQueryCount(DynamicQuery dynamicQuery)
		throws SystemException {
		return jiraChangeItemPersistence.countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Gets the j i r a change item with the primary key.
	 *
	 * @param jiraChangeItemId the primary key of the j i r a change item to get
	 * @return the j i r a change item
	 * @throws PortalException if a j i r a change item with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public JIRAChangeItem getJIRAChangeItem(long jiraChangeItemId)
		throws PortalException, SystemException {
		return jiraChangeItemPersistence.findByPrimaryKey(jiraChangeItemId);
	}

	/**
	 * Gets a range of all the j i r a change items.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of j i r a change items to return
	 * @param end the upper bound of the range of j i r a change items to return (not inclusive)
	 * @return the range of j i r a change items
	 * @throws SystemException if a system exception occurred
	 */
	public List<JIRAChangeItem> getJIRAChangeItems(int start, int end)
		throws SystemException {
		return jiraChangeItemPersistence.findAll(start, end);
	}

	/**
	 * Gets the number of j i r a change items.
	 *
	 * @return the number of j i r a change items
	 * @throws SystemException if a system exception occurred
	 */
	public int getJIRAChangeItemsCount() throws SystemException {
		return jiraChangeItemPersistence.countAll();
	}

	/**
	 * Updates the j i r a change item in the database. Also notifies the appropriate model listeners.
	 *
	 * @param jiraChangeItem the j i r a change item to update
	 * @return the j i r a change item that was updated
	 * @throws SystemException if a system exception occurred
	 */
	public JIRAChangeItem updateJIRAChangeItem(JIRAChangeItem jiraChangeItem)
		throws SystemException {
		jiraChangeItem.setNew(false);

		return jiraChangeItemPersistence.update(jiraChangeItem, true);
	}

	/**
	 * Updates the j i r a change item in the database. Also notifies the appropriate model listeners.
	 *
	 * @param jiraChangeItem the j i r a change item to update
	 * @param merge whether to merge the j i r a change item with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	 * @return the j i r a change item that was updated
	 * @throws SystemException if a system exception occurred
	 */
	public JIRAChangeItem updateJIRAChangeItem(JIRAChangeItem jiraChangeItem,
		boolean merge) throws SystemException {
		jiraChangeItem.setNew(false);

		return jiraChangeItemPersistence.update(jiraChangeItem, merge);
	}

	/**
	 * Gets the j i r a action local service.
	 *
	 * @return the j i r a action local service
	 */
	public JIRAActionLocalService getJIRAActionLocalService() {
		return jiraActionLocalService;
	}

	/**
	 * Sets the j i r a action local service.
	 *
	 * @param jiraActionLocalService the j i r a action local service
	 */
	public void setJIRAActionLocalService(
		JIRAActionLocalService jiraActionLocalService) {
		this.jiraActionLocalService = jiraActionLocalService;
	}

	/**
	 * Gets the j i r a action persistence.
	 *
	 * @return the j i r a action persistence
	 */
	public JIRAActionPersistence getJIRAActionPersistence() {
		return jiraActionPersistence;
	}

	/**
	 * Sets the j i r a action persistence.
	 *
	 * @param jiraActionPersistence the j i r a action persistence
	 */
	public void setJIRAActionPersistence(
		JIRAActionPersistence jiraActionPersistence) {
		this.jiraActionPersistence = jiraActionPersistence;
	}

	/**
	 * Gets the j i r a action finder.
	 *
	 * @return the j i r a action finder
	 */
	public JIRAActionFinder getJIRAActionFinder() {
		return jiraActionFinder;
	}

	/**
	 * Sets the j i r a action finder.
	 *
	 * @param jiraActionFinder the j i r a action finder
	 */
	public void setJIRAActionFinder(JIRAActionFinder jiraActionFinder) {
		this.jiraActionFinder = jiraActionFinder;
	}

	/**
	 * Gets the j i r a change group local service.
	 *
	 * @return the j i r a change group local service
	 */
	public JIRAChangeGroupLocalService getJIRAChangeGroupLocalService() {
		return jiraChangeGroupLocalService;
	}

	/**
	 * Sets the j i r a change group local service.
	 *
	 * @param jiraChangeGroupLocalService the j i r a change group local service
	 */
	public void setJIRAChangeGroupLocalService(
		JIRAChangeGroupLocalService jiraChangeGroupLocalService) {
		this.jiraChangeGroupLocalService = jiraChangeGroupLocalService;
	}

	/**
	 * Gets the j i r a change group persistence.
	 *
	 * @return the j i r a change group persistence
	 */
	public JIRAChangeGroupPersistence getJIRAChangeGroupPersistence() {
		return jiraChangeGroupPersistence;
	}

	/**
	 * Sets the j i r a change group persistence.
	 *
	 * @param jiraChangeGroupPersistence the j i r a change group persistence
	 */
	public void setJIRAChangeGroupPersistence(
		JIRAChangeGroupPersistence jiraChangeGroupPersistence) {
		this.jiraChangeGroupPersistence = jiraChangeGroupPersistence;
	}

	/**
	 * Gets the j i r a change group finder.
	 *
	 * @return the j i r a change group finder
	 */
	public JIRAChangeGroupFinder getJIRAChangeGroupFinder() {
		return jiraChangeGroupFinder;
	}

	/**
	 * Sets the j i r a change group finder.
	 *
	 * @param jiraChangeGroupFinder the j i r a change group finder
	 */
	public void setJIRAChangeGroupFinder(
		JIRAChangeGroupFinder jiraChangeGroupFinder) {
		this.jiraChangeGroupFinder = jiraChangeGroupFinder;
	}

	/**
	 * Gets the j i r a change item local service.
	 *
	 * @return the j i r a change item local service
	 */
	public JIRAChangeItemLocalService getJIRAChangeItemLocalService() {
		return jiraChangeItemLocalService;
	}

	/**
	 * Sets the j i r a change item local service.
	 *
	 * @param jiraChangeItemLocalService the j i r a change item local service
	 */
	public void setJIRAChangeItemLocalService(
		JIRAChangeItemLocalService jiraChangeItemLocalService) {
		this.jiraChangeItemLocalService = jiraChangeItemLocalService;
	}

	/**
	 * Gets the j i r a change item persistence.
	 *
	 * @return the j i r a change item persistence
	 */
	public JIRAChangeItemPersistence getJIRAChangeItemPersistence() {
		return jiraChangeItemPersistence;
	}

	/**
	 * Sets the j i r a change item persistence.
	 *
	 * @param jiraChangeItemPersistence the j i r a change item persistence
	 */
	public void setJIRAChangeItemPersistence(
		JIRAChangeItemPersistence jiraChangeItemPersistence) {
		this.jiraChangeItemPersistence = jiraChangeItemPersistence;
	}

	/**
	 * Gets the j i r a issue local service.
	 *
	 * @return the j i r a issue local service
	 */
	public JIRAIssueLocalService getJIRAIssueLocalService() {
		return jiraIssueLocalService;
	}

	/**
	 * Sets the j i r a issue local service.
	 *
	 * @param jiraIssueLocalService the j i r a issue local service
	 */
	public void setJIRAIssueLocalService(
		JIRAIssueLocalService jiraIssueLocalService) {
		this.jiraIssueLocalService = jiraIssueLocalService;
	}

	/**
	 * Gets the j i r a issue persistence.
	 *
	 * @return the j i r a issue persistence
	 */
	public JIRAIssuePersistence getJIRAIssuePersistence() {
		return jiraIssuePersistence;
	}

	/**
	 * Sets the j i r a issue persistence.
	 *
	 * @param jiraIssuePersistence the j i r a issue persistence
	 */
	public void setJIRAIssuePersistence(
		JIRAIssuePersistence jiraIssuePersistence) {
		this.jiraIssuePersistence = jiraIssuePersistence;
	}

	/**
	 * Gets the j i r a issue finder.
	 *
	 * @return the j i r a issue finder
	 */
	public JIRAIssueFinder getJIRAIssueFinder() {
		return jiraIssueFinder;
	}

	/**
	 * Sets the j i r a issue finder.
	 *
	 * @param jiraIssueFinder the j i r a issue finder
	 */
	public void setJIRAIssueFinder(JIRAIssueFinder jiraIssueFinder) {
		this.jiraIssueFinder = jiraIssueFinder;
	}

	/**
	 * Gets the s v n repository local service.
	 *
	 * @return the s v n repository local service
	 */
	public SVNRepositoryLocalService getSVNRepositoryLocalService() {
		return svnRepositoryLocalService;
	}

	/**
	 * Sets the s v n repository local service.
	 *
	 * @param svnRepositoryLocalService the s v n repository local service
	 */
	public void setSVNRepositoryLocalService(
		SVNRepositoryLocalService svnRepositoryLocalService) {
		this.svnRepositoryLocalService = svnRepositoryLocalService;
	}

	/**
	 * Gets the s v n repository persistence.
	 *
	 * @return the s v n repository persistence
	 */
	public SVNRepositoryPersistence getSVNRepositoryPersistence() {
		return svnRepositoryPersistence;
	}

	/**
	 * Sets the s v n repository persistence.
	 *
	 * @param svnRepositoryPersistence the s v n repository persistence
	 */
	public void setSVNRepositoryPersistence(
		SVNRepositoryPersistence svnRepositoryPersistence) {
		this.svnRepositoryPersistence = svnRepositoryPersistence;
	}

	/**
	 * Gets the s v n revision local service.
	 *
	 * @return the s v n revision local service
	 */
	public SVNRevisionLocalService getSVNRevisionLocalService() {
		return svnRevisionLocalService;
	}

	/**
	 * Sets the s v n revision local service.
	 *
	 * @param svnRevisionLocalService the s v n revision local service
	 */
	public void setSVNRevisionLocalService(
		SVNRevisionLocalService svnRevisionLocalService) {
		this.svnRevisionLocalService = svnRevisionLocalService;
	}

	/**
	 * Gets the s v n revision persistence.
	 *
	 * @return the s v n revision persistence
	 */
	public SVNRevisionPersistence getSVNRevisionPersistence() {
		return svnRevisionPersistence;
	}

	/**
	 * Sets the s v n revision persistence.
	 *
	 * @param svnRevisionPersistence the s v n revision persistence
	 */
	public void setSVNRevisionPersistence(
		SVNRevisionPersistence svnRevisionPersistence) {
		this.svnRevisionPersistence = svnRevisionPersistence;
	}

	/**
	 * Gets the counter local service.
	 *
	 * @return the counter local service
	 */
	public CounterLocalService getCounterLocalService() {
		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(CounterLocalService counterLocalService) {
		this.counterLocalService = counterLocalService;
	}

	/**
	 * Gets the resource local service.
	 *
	 * @return the resource local service
	 */
	public ResourceLocalService getResourceLocalService() {
		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		ResourceLocalService resourceLocalService) {
		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Gets the resource remote service.
	 *
	 * @return the resource remote service
	 */
	public ResourceService getResourceService() {
		return resourceService;
	}

	/**
	 * Sets the resource remote service.
	 *
	 * @param resourceService the resource remote service
	 */
	public void setResourceService(ResourceService resourceService) {
		this.resourceService = resourceService;
	}

	/**
	 * Gets the resource persistence.
	 *
	 * @return the resource persistence
	 */
	public ResourcePersistence getResourcePersistence() {
		return resourcePersistence;
	}

	/**
	 * Sets the resource persistence.
	 *
	 * @param resourcePersistence the resource persistence
	 */
	public void setResourcePersistence(ResourcePersistence resourcePersistence) {
		this.resourcePersistence = resourcePersistence;
	}

	/**
	 * Gets the user local service.
	 *
	 * @return the user local service
	 */
	public UserLocalService getUserLocalService() {
		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(UserLocalService userLocalService) {
		this.userLocalService = userLocalService;
	}

	/**
	 * Gets the user remote service.
	 *
	 * @return the user remote service
	 */
	public UserService getUserService() {
		return userService;
	}

	/**
	 * Sets the user remote service.
	 *
	 * @param userService the user remote service
	 */
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	/**
	 * Gets the user persistence.
	 *
	 * @return the user persistence
	 */
	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	/**
	 * Sets the user persistence.
	 *
	 * @param userPersistence the user persistence
	 */
	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query to perform
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = jiraChangeItemPersistence.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = JIRAActionLocalService.class)
	protected JIRAActionLocalService jiraActionLocalService;
	@BeanReference(type = JIRAActionPersistence.class)
	protected JIRAActionPersistence jiraActionPersistence;
	@BeanReference(type = JIRAActionFinder.class)
	protected JIRAActionFinder jiraActionFinder;
	@BeanReference(type = JIRAChangeGroupLocalService.class)
	protected JIRAChangeGroupLocalService jiraChangeGroupLocalService;
	@BeanReference(type = JIRAChangeGroupPersistence.class)
	protected JIRAChangeGroupPersistence jiraChangeGroupPersistence;
	@BeanReference(type = JIRAChangeGroupFinder.class)
	protected JIRAChangeGroupFinder jiraChangeGroupFinder;
	@BeanReference(type = JIRAChangeItemLocalService.class)
	protected JIRAChangeItemLocalService jiraChangeItemLocalService;
	@BeanReference(type = JIRAChangeItemPersistence.class)
	protected JIRAChangeItemPersistence jiraChangeItemPersistence;
	@BeanReference(type = JIRAIssueLocalService.class)
	protected JIRAIssueLocalService jiraIssueLocalService;
	@BeanReference(type = JIRAIssuePersistence.class)
	protected JIRAIssuePersistence jiraIssuePersistence;
	@BeanReference(type = JIRAIssueFinder.class)
	protected JIRAIssueFinder jiraIssueFinder;
	@BeanReference(type = SVNRepositoryLocalService.class)
	protected SVNRepositoryLocalService svnRepositoryLocalService;
	@BeanReference(type = SVNRepositoryPersistence.class)
	protected SVNRepositoryPersistence svnRepositoryPersistence;
	@BeanReference(type = SVNRevisionLocalService.class)
	protected SVNRevisionLocalService svnRevisionLocalService;
	@BeanReference(type = SVNRevisionPersistence.class)
	protected SVNRevisionPersistence svnRevisionPersistence;
	@BeanReference(type = CounterLocalService.class)
	protected CounterLocalService counterLocalService;
	@BeanReference(type = ResourceLocalService.class)
	protected ResourceLocalService resourceLocalService;
	@BeanReference(type = ResourceService.class)
	protected ResourceService resourceService;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserLocalService.class)
	protected UserLocalService userLocalService;
	@BeanReference(type = UserService.class)
	protected UserService userService;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
}