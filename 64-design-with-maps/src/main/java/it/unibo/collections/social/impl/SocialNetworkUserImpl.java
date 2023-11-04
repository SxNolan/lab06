/**
 * 
 */
package it.unibo.collections.social.impl;

import it.unibo.collections.social.api.SocialNetworkUser;
import it.unibo.collections.social.api.User;

import java.util.ArrayList;
//import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
//import java.util.Collections;
import java.util.HashMap;
//import java.util.HashSet;
import java.util.List;
import java.util.Map;
//import java.util.Set;

/**
 * 
 * This will be an implementation of
 * {@link SocialNetworkUser}:
 * 1) complete the definition of the methods by following the suggestions
 * included in the comments below.
 * 
 * @param <U>
 *            Specific {@link User} type
 */
public final class SocialNetworkUserImpl<U extends User> extends UserImpl implements SocialNetworkUser<User> {


    private final Map<String, ArrayList<User>> group;

    /*
     *
     * [FIELDS]
     *
     * Define any necessary field
     *
     * In order to save the people followed by a user organized in groups, adopt
     * a generic-type Map:  think of what type of keys and values would best suit the requirements
     */

    /*
     * [CONSTRUCTORS]
     *
     * 1) Complete the definition of the constructor below, for building a user
     * participating in a social network, with 4 parameters, initializing:
     *
     * - firstName
     * - lastName
     * - username
     * - age and every other necessary field
     */
    /**
     * Builds a user participating in a social network.
     *
     * @param name
     *            the user firstname
     * @param surname
     *            the user lastname
     * @param userAge
     *            user's age
     * @param user
     *            alias of the user, i.e. the way a user is identified on an
     *            application
     */
    public SocialNetworkUserImpl(final String name, final String surname, final String user, final int userAge) {
        super(name, surname, user, userAge);
        this.group = new HashMap<>();
    }

    public SocialNetworkUserImpl(final String name, final String surname, final String user) {
        super(name, surname, user, -1);
        this.group = new HashMap<>();
    }

    /*
     * [METHODS]
     *
     * Implements the methods below
     */
    @Override
    public boolean addFollowedUser(final String circle, final User user) {
        ArrayList<User> tempList = this.group.get(circle);
        if (tempList == null) {
            tempList = new ArrayList<>();
            this.group.put(circle, tempList);
        }
        return tempList.add(user);
    }

    /**
     *
     * [NOTE] If no group with groupName exists yet, this implementation must
     * return an empty Collection.
     */
    @Override
    public Collection<User> getFollowedUsersInGroup(final String groupName) {
        final Collection<User> usersCircle = this.group.get(groupName);
        if (usersCircle != null) {
            return new ArrayList<>(usersCircle);
        }
        return Collections.emptyList();
    }

    @Override
    public List<User> getFollowedUsers() {
        final List<User> tempList = new ArrayList<>();
        for (final ArrayList<User> elem : group.values()) {
            tempList.addAll(elem);
        }
    return new ArrayList<>(tempList);    
    }
}
