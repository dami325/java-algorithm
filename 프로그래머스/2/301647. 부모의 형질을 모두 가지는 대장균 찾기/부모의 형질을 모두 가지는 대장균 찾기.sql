-- 코드를 작성해주세요
SELECT
        
        
          
              ED.ID,
        
        
          
              ED.GENOTYPE,
        
        
          
              ED2.GENOTYPE AS PARENT_GENOTYPE
        
        
          
          FROM
        
        
          
              ECOLI_DATA ED
        
        
          
          INNER JOIN
        
        
          
              ECOLI_DATA ED2
        
        
          
          ON
        
        
          
              ED2.ID = ED.PARENT_ID
        
        
          
          WHERE
        
        
          
              ED.GENOTYPE & ED2.GENOTYPE = ED2.GENOTYPE
        
        
          
          ORDER BY
        
        
          
              ED.ID ASC