import { defineStore } from 'pinia'
import type { ProjectInterface } from '@/interfaces/project.interface'

export const useProjectStore = defineStore('project', {
    state: () => ({
        projects: [] as ProjectInterface[],
        loading: false,
        error: null as null | string,
    }),
})
