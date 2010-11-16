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

package com.liferay.socialnetworking.service.base;

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

import com.liferay.socialnetworking.model.MeetupsEntry;
import com.liferay.socialnetworking.service.MeetupsEntryLocalService;
import com.liferay.socialnetworking.service.MeetupsRegistrationLocalService;
import com.liferay.socialnetworking.service.WallEntryLocalService;
import com.liferay.socialnetworking.service.persistence.MeetupsEntryPersistence;
import com.liferay.socialnetworking.service.persistence.MeetupsRegistrationPersistence;
import com.liferay.socialnetworking.service.persistence.WallEntryFinder;
import com.liferay.socialnetworking.service.persistence.WallEntryPersistence;

import java.util.List;

import javax.sql.DataSource;

/**
 * The base implementation of the meetups entry local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.liferay.socialnetworking.service.impl.MeetupsEntryLocalServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.socialnetworking.service.impl.MeetupsEntryLocalServiceImpl
 * @see com.liferay.socialnetworking.service.MeetupsEntryLocalServiceUtil
 * @generated
 */
public abstract class MeetupsEntryLocalServiceBaseImpl
	implements MeetupsEntryLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.liferay.socialnetworking.service.MeetupsEntryLocalServiceUtil} to access the meetups entry local service.
	 */

	/**
	 * Adds the meetups entry to the database. Also notifies the appropriate model listeners.
	 *
	 * @param meetupsEntry the meetups entry to add
	 * @return the meetups entry that was added
	 * @throws SystemException if a system exception occurred
	 */
	public MeetupsEntry addMeetupsEntry(MeetupsEntry meetupsEntry)
		throws SystemException {
		meetupsEntry.setNew(true);

		return meetupsEntryPersistence.update(meetupsEntry, false);
	}

	/**
	 * Creates a new meetups entry with the primary key. Does not add the meetups entry to the database.
	 *
	 * @param meetupsEntryId the primary key for the new meetups entry
	 * @return the new meetups entry
	 */
	public MeetupsEntry createMeetupsEntry(long meetupsEntryId) {
		return meetupsEntryPersistence.create(meetupsEntryId);
	}

	/**
	 * Deletes the meetups entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param meetupsEntryId the primary key of the meetups entry to delete
	 * @throws PortalException if a meetups entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public void deleteMeetupsEntry(long meetupsEntryId)
		throws PortalException, SystemException {
		meetupsEntryPersistence.remove(meetupsEntryId);
	}

	/**
	 * Deletes the meetups entry from the database. Also notifies the appropriate model listeners.
	 *
	 * @param meetupsEntry the meetups entry to delete
	 * @throws SystemException if a system exception occurred
	 */
	public void deleteMeetupsEntry(MeetupsEntry meetupsEntry)
		throws SystemException {
		meetupsEntryPersistence.remove(meetupsEntry);
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
		return meetupsEntryPersistence.findWithDynamicQuery(dynamicQuery);
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
		return meetupsEntryPersistence.findWithDynamicQuery(dynamicQuery,
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
		return meetupsEntryPersistence.findWithDynamicQuery(dynamicQuery,
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
		return meetupsEntryPersistence.countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Gets the meetups entry with the primary key.
	 *
	 * @param meetupsEntryId the primary key of the meetups entry to get
	 * @return the meetups entry
	 * @throws PortalException if a meetups entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public MeetupsEntry getMeetupsEntry(long meetupsEntryId)
		throws PortalException, SystemException {
		return meetupsEntryPersistence.findByPrimaryKey(meetupsEntryId);
	}

	/**
	 * Gets a range of all the meetups entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of meetups entries to return
	 * @param end the upper bound of the range of meetups entries to return (not inclusive)
	 * @return the range of meetups entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<MeetupsEntry> getMeetupsEntries(int start, int end)
		throws SystemException {
		return meetupsEntryPersistence.findAll(start, end);
	}

	/**
	 * Gets the number of meetups entries.
	 *
	 * @return the number of meetups entries
	 * @throws SystemException if a system exception occurred
	 */
	public int getMeetupsEntriesCount() throws SystemException {
		return meetupsEntryPersistence.countAll();
	}

	/**
	 * Updates the meetups entry in the database. Also notifies the appropriate model listeners.
	 *
	 * @param meetupsEntry the meetups entry to update
	 * @return the meetups entry that was updated
	 * @throws SystemException if a system exception occurred
	 */
	public MeetupsEntry updateMeetupsEntry(MeetupsEntry meetupsEntry)
		throws SystemException {
		meetupsEntry.setNew(false);

		return meetupsEntryPersistence.update(meetupsEntry, true);
	}

	/**
	 * Updates the meetups entry in the database. Also notifies the appropriate model listeners.
	 *
	 * @param meetupsEntry the meetups entry to update
	 * @param merge whether to merge the meetups entry with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	 * @return the meetups entry that was updated
	 * @throws SystemException if a system exception occurred
	 */
	public MeetupsEntry updateMeetupsEntry(MeetupsEntry meetupsEntry,
		boolean merge) throws SystemException {
		meetupsEntry.setNew(false);

		return meetupsEntryPersistence.update(meetupsEntry, merge);
	}

	/**
	 * Gets the meetups entry local service.
	 *
	 * @return the meetups entry local service
	 */
	public MeetupsEntryLocalService getMeetupsEntryLocalService() {
		return meetupsEntryLocalService;
	}

	/**
	 * Sets the meetups entry local service.
	 *
	 * @param meetupsEntryLocalService the meetups entry local service
	 */
	public void setMeetupsEntryLocalService(
		MeetupsEntryLocalService meetupsEntryLocalService) {
		this.meetupsEntryLocalService = meetupsEntryLocalService;
	}

	/**
	 * Gets the meetups entry persistence.
	 *
	 * @return the meetups entry persistence
	 */
	public MeetupsEntryPersistence getMeetupsEntryPersistence() {
		return meetupsEntryPersistence;
	}

	/**
	 * Sets the meetups entry persistence.
	 *
	 * @param meetupsEntryPersistence the meetups entry persistence
	 */
	public void setMeetupsEntryPersistence(
		MeetupsEntryPersistence meetupsEntryPersistence) {
		this.meetupsEntryPersistence = meetupsEntryPersistence;
	}

	/**
	 * Gets the meetups registration local service.
	 *
	 * @return the meetups registration local service
	 */
	public MeetupsRegistrationLocalService getMeetupsRegistrationLocalService() {
		return meetupsRegistrationLocalService;
	}

	/**
	 * Sets the meetups registration local service.
	 *
	 * @param meetupsRegistrationLocalService the meetups registration local service
	 */
	public void setMeetupsRegistrationLocalService(
		MeetupsRegistrationLocalService meetupsRegistrationLocalService) {
		this.meetupsRegistrationLocalService = meetupsRegistrationLocalService;
	}

	/**
	 * Gets the meetups registration persistence.
	 *
	 * @return the meetups registration persistence
	 */
	public MeetupsRegistrationPersistence getMeetupsRegistrationPersistence() {
		return meetupsRegistrationPersistence;
	}

	/**
	 * Sets the meetups registration persistence.
	 *
	 * @param meetupsRegistrationPersistence the meetups registration persistence
	 */
	public void setMeetupsRegistrationPersistence(
		MeetupsRegistrationPersistence meetupsRegistrationPersistence) {
		this.meetupsRegistrationPersistence = meetupsRegistrationPersistence;
	}

	/**
	 * Gets the wall entry local service.
	 *
	 * @return the wall entry local service
	 */
	public WallEntryLocalService getWallEntryLocalService() {
		return wallEntryLocalService;
	}

	/**
	 * Sets the wall entry local service.
	 *
	 * @param wallEntryLocalService the wall entry local service
	 */
	public void setWallEntryLocalService(
		WallEntryLocalService wallEntryLocalService) {
		this.wallEntryLocalService = wallEntryLocalService;
	}

	/**
	 * Gets the wall entry persistence.
	 *
	 * @return the wall entry persistence
	 */
	public WallEntryPersistence getWallEntryPersistence() {
		return wallEntryPersistence;
	}

	/**
	 * Sets the wall entry persistence.
	 *
	 * @param wallEntryPersistence the wall entry persistence
	 */
	public void setWallEntryPersistence(
		WallEntryPersistence wallEntryPersistence) {
		this.wallEntryPersistence = wallEntryPersistence;
	}

	/**
	 * Gets the wall entry finder.
	 *
	 * @return the wall entry finder
	 */
	public WallEntryFinder getWallEntryFinder() {
		return wallEntryFinder;
	}

	/**
	 * Sets the wall entry finder.
	 *
	 * @param wallEntryFinder the wall entry finder
	 */
	public void setWallEntryFinder(WallEntryFinder wallEntryFinder) {
		this.wallEntryFinder = wallEntryFinder;
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
			DataSource dataSource = meetupsEntryPersistence.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = MeetupsEntryLocalService.class)
	protected MeetupsEntryLocalService meetupsEntryLocalService;
	@BeanReference(type = MeetupsEntryPersistence.class)
	protected MeetupsEntryPersistence meetupsEntryPersistence;
	@BeanReference(type = MeetupsRegistrationLocalService.class)
	protected MeetupsRegistrationLocalService meetupsRegistrationLocalService;
	@BeanReference(type = MeetupsRegistrationPersistence.class)
	protected MeetupsRegistrationPersistence meetupsRegistrationPersistence;
	@BeanReference(type = WallEntryLocalService.class)
	protected WallEntryLocalService wallEntryLocalService;
	@BeanReference(type = WallEntryPersistence.class)
	protected WallEntryPersistence wallEntryPersistence;
	@BeanReference(type = WallEntryFinder.class)
	protected WallEntryFinder wallEntryFinder;
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