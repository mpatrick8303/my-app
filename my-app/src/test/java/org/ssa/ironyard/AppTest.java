package org.ssa.ironyard;

import static org.junit.Assert.*;

import org.junit.Test;

import junit.framework.TestCase;

public class AppTest extends TestCase
{
    @Test
    public void testApp()
    {
        assertTrue(true);
    }
    
    @Test
    public void silly()
    {
        assertFalse("this should fail",false);
    }
}
